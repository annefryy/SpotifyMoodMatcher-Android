package com.annefryy.spotifymoodmatcher.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.annefryy.spotifymoodmatcher.R
import com.annefryy.spotifymoodmatcher.data.auth.SpotifyAuthManager
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import android.app.Activity

@Composable
fun LoginScreen(
    onNavigateToMoodInput: () -> Unit,
    authManager: SpotifyAuthManager,
    activity: Activity
) {
    val isAuthenticated by authManager.isAuthenticated.collectAsState()
    var showError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(isAuthenticated) {
        if (isAuthenticated) {
            onNavigateToMoodInput()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // App Logo
        Image(
            painter = painterResource(id = R.drawable.app_logo),
            contentDescription = "App Logo",
            modifier = Modifier
                .size(120.dp)
                .padding(bottom = 32.dp)
        )
        
        Text(
            text = "Welcome to Spotify Mood Matcher",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        Text(
            text = "Connect your Spotify account to get started",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        
        if (showError) {
            Text(
                text = errorMessage ?: "An error occurred",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        
        Button(
            onClick = {
                try {
                    authManager.startAuth(activity)
                    showError = false
                    errorMessage = null
                } catch (e: Exception) {
                    showError = true
                    errorMessage = e.message ?: "Failed to start authentication"
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Connect with Spotify")
        }
    }
}

@HiltViewModel
class LoginViewModel @Inject constructor(
    val authManager: SpotifyAuthManager
) : androidx.lifecycle.ViewModel() 