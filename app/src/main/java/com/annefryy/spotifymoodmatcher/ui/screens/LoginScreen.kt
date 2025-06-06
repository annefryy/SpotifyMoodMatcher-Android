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
import androidx.hilt.navigation.compose.hiltViewModel
import com.annefryy.spotifymoodmatcher.R
import com.annefryy.spotifymoodmatcher.data.auth.SpotifyAuthManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    authManager: SpotifyAuthManager = hiltViewModel<LoginViewModel>().authManager
) {
    var isLoading by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        if (authManager.isAuthenticated()) {
            onLoginSuccess()
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
            text = "Create playlists based on your mood",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        
        if (error != null) {
            Text(
                text = error!!,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        
        if (isLoading) {
            CircularProgressIndicator()
        } else {
            Button(
                onClick = {
                    isLoading = true
                    error = null
                    try {
                        authManager.startAuth()
                    } catch (e: Exception) {
                        error = e.message
                        isLoading = false
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Login with Spotify")
            }
        }
    }
}

@HiltViewModel
class LoginViewModel @Inject constructor(
    val authManager: SpotifyAuthManager
) : androidx.lifecycle.ViewModel() 