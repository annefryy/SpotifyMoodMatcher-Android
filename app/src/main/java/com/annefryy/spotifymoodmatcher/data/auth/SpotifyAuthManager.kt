package com.annefryy.spotifymoodmatcher.data.auth

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Base64
import android.util.Log
import com.annefryy.spotifymoodmatcher.data.config.SpotifyConfig
import com.annefryy.spotifymoodmatcher.data.storage.SecureStorageManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import javax.inject.Inject
import javax.inject.Singleton
import dagger.hilt.android.qualifiers.ApplicationContext

@Singleton
class SpotifyAuthManager @Inject constructor(
    @ApplicationContext private val context: Context,
    private val secureStorageManager: SecureStorageManager
) {
    private val client = OkHttpClient()
    private val TAG = "SpotifyAuthManager"

    fun getAuthUrl(): String {
        val url = SpotifyConfig.AUTH_URL
        Log.d(TAG, "Generated auth URL: $url")
        return url
    }

    suspend fun handleAuthResponse(uri: Uri): Boolean {
        Log.d(TAG, "Handling auth response: $uri")
        val code = uri.getQueryParameter("code")
        if (code == null) {
            Log.e(TAG, "No authorization code found in URI")
            return false
        }
        
        return try {
            Log.d(TAG, "Exchanging code for token")
            val tokenResponse = exchangeCodeForToken(code)
            Log.d(TAG, "Token exchange successful")
            secureStorageManager.saveAccessToken(tokenResponse.accessToken)
            tokenResponse.refreshToken?.let { 
                secureStorageManager.saveRefreshToken(it)
                Log.d(TAG, "Refresh token saved")
            }
            true
        } catch (e: Exception) {
            Log.e(TAG, "Error handling auth response", e)
            false
        }
    }

    private suspend fun exchangeCodeForToken(code: String): TokenResponse = withContext(Dispatchers.IO) {
        Log.d(TAG, "Starting token exchange")
        val requestBody = FormBody.Builder()
            .add("grant_type", "authorization_code")
            .add("code", code)
            .add("redirect_uri", SpotifyConfig.REDIRECT_URI)
            .build()

        val credentials = "${SpotifyConfig.CLIENT_ID}:${SpotifyConfig.CLIENT_SECRET}"
        val encodedCredentials = Base64.encodeToString(credentials.toByteArray(), Base64.NO_WRAP)

        val request = Request.Builder()
            .url(SpotifyConfig.TOKEN_ENDPOINT)
            .post(requestBody)
            .addHeader("Authorization", "Basic $encodedCredentials")
            .build()

        val response = client.newCall(request).execute()
        if (!response.isSuccessful) {
            val errorBody = response.body?.string()
            Log.e(TAG, "Token exchange failed: ${response.code}, $errorBody")
            throw Exception("Failed to exchange code for token: ${response.code}, $errorBody")
        }
        
        val responseBody = response.body?.string()
        Log.d(TAG, "Token exchange response: $responseBody")
        val jsonResponse = JSONObject(responseBody ?: "")
        
        TokenResponse(
            accessToken = jsonResponse.getString("access_token"),
            refreshToken = jsonResponse.optString("refresh_token"),
            expiresIn = jsonResponse.getInt("expires_in")
        )
    }

    suspend fun refreshToken(): Boolean {
        Log.d(TAG, "Attempting to refresh token")
        val refreshToken = secureStorageManager.getRefreshToken()
        if (refreshToken == null) {
            Log.e(TAG, "No refresh token available")
            return false
        }
        
        return try {
            val requestBody = FormBody.Builder()
                .add("grant_type", "refresh_token")
                .add("refresh_token", refreshToken)
                .build()

            val credentials = "${SpotifyConfig.CLIENT_ID}:${SpotifyConfig.CLIENT_SECRET}"
            val encodedCredentials = Base64.encodeToString(credentials.toByteArray(), Base64.NO_WRAP)

            val request = Request.Builder()
                .url(SpotifyConfig.TOKEN_ENDPOINT)
                .post(requestBody)
                .addHeader("Authorization", "Basic $encodedCredentials")
                .build()

            val response = client.newCall(request).execute()
            if (!response.isSuccessful) {
                val errorBody = response.body?.string()
                Log.e(TAG, "Token refresh failed: ${response.code}, $errorBody")
                throw Exception("Failed to refresh token: ${response.code}, $errorBody")
            }
            
            val responseBody = response.body?.string()
            Log.d(TAG, "Token refresh response: $responseBody")
            val jsonResponse = JSONObject(responseBody ?: "")
            val newToken = jsonResponse.getString("access_token")
            secureStorageManager.saveAccessToken(newToken)
            Log.d(TAG, "New access token saved")
            true
        } catch (e: Exception) {
            Log.e(TAG, "Error refreshing token", e)
            false
        }
    }

    fun startAuth() {
        try {
            val authUrl = getAuthUrl()
            Log.d(TAG, "Starting auth with URL: $authUrl")
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(authUrl)).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            context.startActivity(intent)
        } catch (e: Exception) {
            Log.e(TAG, "Error starting auth", e)
        }
    }

    fun isAuthenticated(): Boolean {
        val isAuthenticated = secureStorageManager.getAccessToken() != null
        Log.d(TAG, "Checking authentication status: $isAuthenticated")
        return isAuthenticated
    }

    fun logout() {
        Log.d(TAG, "Logging out")
        secureStorageManager.clearTokens()
    }

    data class TokenResponse(
        val accessToken: String,
        val refreshToken: String?,
        val expiresIn: Int
    )
} 