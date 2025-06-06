package com.annefryy.spotifymoodmatcher

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.annefryy.spotifymoodmatcher.data.auth.SpotifyAuthManager
import com.annefryy.spotifymoodmatcher.ui.navigation.NavGraph
import com.annefryy.spotifymoodmatcher.ui.theme.SpotifyMoodMatcherTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var authManager: SpotifyAuthManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpotifyMoodMatcherTheme {
                var isAuthenticated by remember { mutableStateOf(false) }
                var authError by remember { mutableStateOf<String?>(null) }

                LaunchedEffect(Unit) {
                    isAuthenticated = authManager.isAuthenticated()
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavGraph(
                        navController = navController,
                        onLogout = {
                            authManager.logout()
                            isAuthenticated = false
                        }
                    )
                }
            }
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.data?.let { uri ->
            // Check if this is the Spotify redirect URI
            if (uri.toString().startsWith(com.annefryy.spotifymoodmatcher.data.config.SpotifyConfig.REDIRECT_URI)) {
                lifecycleScope.launch {
                    val success = authManager.handleAuthResponse(uri)
                    // Optionally, update UI or state here
                }
            }
        }
    }
} 