package com.annefryy.spotifymoodmatcher.auth

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.annefryy.spotifymoodmatcher.MainActivity
import com.annefryy.spotifymoodmatcher.data.auth.SpotifyAuthManager
import com.annefryy.spotifymoodmatcher.ui.theme.SpotifyMoodMatcherTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SpotifyCallbackActivity : ComponentActivity() {
    @Inject
    lateinit var authManager: SpotifyAuthManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpotifyMoodMatcherTheme {
                var isLoading by remember { mutableStateOf(true) }
                var error by remember { mutableStateOf<String?>(null) }

                LaunchedEffect(Unit) {
                    try {
                        val uri = intent.data
                        if (uri != null) {
                            val success = authManager.handleAuthResponse(uri)
                            if (success) {
                                startActivity(Intent(this@SpotifyCallbackActivity, MainActivity::class.java))
                                finish()
                            } else {
                                error = "Authentication failed. Please try again."
                            }
                        } else {
                            error = "Invalid callback URI. Please try again."
                        }
                    } catch (e: Exception) {
                        error = e.message ?: "An unexpected error occurred. Please try again."
                    } finally {
                        isLoading = false
                    }
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        when {
                            isLoading -> CircularProgressIndicator()
                            error != null -> Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Text(
                                    text = error ?: "",
                                    color = MaterialTheme.colorScheme.error,
                                    style = MaterialTheme.typography.bodyLarge
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                Button(
                                    onClick = {
                                        startActivity(Intent(this@SpotifyCallbackActivity, MainActivity::class.java))
                                        finish()
                                    }
                                ) {
                                    Text("Return to Main Screen")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
} 