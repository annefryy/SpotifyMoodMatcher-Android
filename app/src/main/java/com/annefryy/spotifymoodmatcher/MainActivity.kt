package com.annefryy.spotifymoodmatcher

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.annefryy.spotifymoodmatcher.data.auth.SpotifyAuthManager
import com.annefryy.spotifymoodmatcher.ui.navigation.NavGraph
import com.annefryy.spotifymoodmatcher.ui.theme.SpotifyMoodMatcherTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var authManager: SpotifyAuthManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: Starting MainActivity")
        
        setContent {
            Log.d(TAG, "Setting up Compose content")
            val isAuthenticated by authManager.isAuthenticated.collectAsState()
            val navController = rememberNavController()
            
            SpotifyMoodMatcherTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavGraph(
                        navController = navController,
                        onLogout = {
                            Log.d(TAG, "Logging out user")
                            authManager.logout()
                        },
                        authManager = authManager,
                        activity = this@MainActivity
                    )
                }
            }
        }

        // Handle initial intent
        handleIntent(intent)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d(TAG, "onNewIntent: Received new intent")
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent?) {
        intent?.data?.let { uri ->
            if (uri.host == "callback") {
                Log.d(TAG, "onNewIntent: Handling Spotify auth callback")
                lifecycleScope.launch {
                    try {
                        val success = authManager.handleAuthResponse(uri)
                        if (success) {
                            Toast.makeText(this@MainActivity, "Successfully authenticated", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this@MainActivity, "Authentication failed", Toast.LENGTH_SHORT).show()
                        }
                    } catch (e: Exception) {
                        Log.e(TAG, "Error handling auth response", e)
                        Toast.makeText(this@MainActivity, "Authentication error: ${e.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        authManager.handleAuthResponse(requestCode, resultCode, data)
    }
} 