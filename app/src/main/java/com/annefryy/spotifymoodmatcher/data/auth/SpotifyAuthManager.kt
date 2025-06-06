package com.annefryy.spotifymoodmatcher.data.auth

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import com.annefryy.spotifymoodmatcher.data.config.SpotifyConfig
import com.annefryy.spotifymoodmatcher.data.storage.SecureStorageManager
import com.spotify.android.appremote.api.ConnectionParams
import com.spotify.android.appremote.api.Connector
import com.spotify.android.appremote.api.SpotifyAppRemote
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import javax.inject.Inject
import javax.inject.Singleton
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

private const val TAG = "SpotifyAuthManager"
private const val REQUEST_CODE = 1337
private const val SPOTIFY_PACKAGE = "com.spotify.music"

@Singleton
class SpotifyAuthManager @Inject constructor(
    @ApplicationContext private val context: Context,
    private val secureStorage: SecureStorageManager
) {
    private val _isAuthenticated = MutableStateFlow(false)
    val isAuthenticated: StateFlow<Boolean> = _isAuthenticated.asStateFlow()

    private var spotifyAppRemote: SpotifyAppRemote? = null
    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request()
            try {
                chain.proceed(request)
            } catch (e: Exception) {
                Log.e(TAG, "Network error for ${request.url}", e)
                throw e
            }
        }
        .build()

    init {
        Log.d(TAG, "Initializing SpotifyAuthManager")
        checkAuthStatus()
    }

    private fun checkAuthStatus() {
        Log.d(TAG, "Checking authentication status")
        val token = secureStorage.getAccessToken()
        _isAuthenticated.value = !token.isNullOrEmpty()
        Log.d(TAG, "Authentication status: ${_isAuthenticated.value}")
    }

    fun startAuth(activity: Activity) {
        try {
            Log.d(TAG, "Starting native Spotify authentication")
            
            // Check if Spotify app is installed
            val spotifyIntent = activity.packageManager.getLaunchIntentForPackage(SPOTIFY_PACKAGE)
            if (spotifyIntent != null) {
                Log.d(TAG, "Spotify app is installed, using native auth")
                val builder = AuthorizationRequest.Builder(
                    SpotifyConfig.CLIENT_ID,
                    AuthorizationResponse.Type.CODE,
                    SpotifyConfig.REDIRECT_URI
                )
                
                builder.setScopes(SpotifyConfig.SCOPE_LIST.toTypedArray())
                val request = builder.build()
                
                AuthorizationClient.openLoginActivity(
                    activity,
                    REQUEST_CODE,
                    request
                )
            } else {
                Log.d(TAG, "Spotify app is not installed, falling back to web auth")
                fallbackToWebAuth()
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error starting native auth", e)
            fallbackToWebAuth()
        }
    }

    private fun fallbackToWebAuth() {
        try {
            val authUrl = getAuthUrl()
            Log.d(TAG, "Falling back to web auth with URL: $authUrl")
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(authUrl)).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            context.startActivity(intent)
        } catch (e: Exception) {
            Log.e(TAG, "Error starting web auth", e)
            throw e
        }
    }

    private fun getAuthUrl(): String {
        Log.d(TAG, "Generating authentication URL")
        return SpotifyConfig.AUTH_URL
    }

    fun handleAuthResponse(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE) {
            val response = AuthorizationClient.getResponse(resultCode, data)
            when (response.type) {
                AuthorizationResponse.Type.CODE -> {
                    val code = response.code
                    if (code != null) {
                        coroutineScope.launch {
                            try {
                                exchangeCodeForToken(code)
                            } catch (e: Exception) {
                                Log.e(TAG, "Error exchanging code for token", e)
                                fallbackToWebAuth()
                            }
                        }
                    } else {
                        Log.e(TAG, "No authorization code received")
                        fallbackToWebAuth()
                    }
                }
                AuthorizationResponse.Type.ERROR -> {
                    Log.e(TAG, "Auth error: ${response.error}")
                    fallbackToWebAuth()
                }
                else -> {
                    Log.e(TAG, "Unexpected auth response type: ${response.type}")
                    fallbackToWebAuth()
                }
            }
        }
    }

    suspend fun handleAuthResponse(uri: Uri): Boolean = withContext(Dispatchers.IO) {
        Log.d(TAG, "Handling auth response: $uri")
        return@withContext try {
            val code = uri.getQueryParameter("code")
            if (code != null) {
                Log.d(TAG, "Received authorization code")
                exchangeCodeForToken(code)
                true
            } else {
                Log.e(TAG, "No authorization code in response")
                false
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error handling auth response", e)
            false
        }
    }

    private suspend fun exchangeCodeForToken(code: String) = withContext(Dispatchers.IO) {
        Log.d(TAG, "Exchanging code for token")
        val requestBody = FormBody.Builder()
            .add("grant_type", "authorization_code")
            .add("code", code)
            .add("redirect_uri", SpotifyConfig.REDIRECT_URI)
            .add("client_id", SpotifyConfig.CLIENT_ID)
            .add("client_secret", SpotifyConfig.CLIENT_SECRET)
            .build()

        val request = Request.Builder()
            .url(SpotifyConfig.TOKEN_ENDPOINT)
            .post(requestBody)
            .build()

        try {
            client.newCall(request).execute().use { response ->
                if (response.isSuccessful) {
                    val jsonResponse = JSONObject(response.body?.string())
                    val accessToken = jsonResponse.getString("access_token")
                    val refreshToken = jsonResponse.getString("refresh_token")
                    val expiresIn = jsonResponse.getInt("expires_in")

                    Log.d(TAG, "Successfully obtained tokens")
                    secureStorage.saveTokens(accessToken, refreshToken, expiresIn)
                    _isAuthenticated.value = true
                } else {
                    Log.e(TAG, "Failed to exchange code for token: ${response.code}")
                    throw IllegalStateException("Failed to exchange code for token: ${response.code}")
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error exchanging code for token", e)
            throw e
        }
    }

    fun logout() {
        spotifyAppRemote?.let {
            SpotifyAppRemote.disconnect(it)
            spotifyAppRemote = null
        }
        secureStorage.clearTokens()
        _isAuthenticated.value = false
    }

    data class TokenResponse(
        val accessToken: String,
        val refreshToken: String?,
        val expiresIn: Int
    )
} 