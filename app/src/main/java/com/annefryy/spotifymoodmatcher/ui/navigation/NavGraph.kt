package com.annefryy.spotifymoodmatcher.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.annefryy.spotifymoodmatcher.data.auth.SpotifyAuthManager
import com.annefryy.spotifymoodmatcher.ui.screens.LoginScreen
import com.annefryy.spotifymoodmatcher.ui.screens.MoodInputScreen
import com.annefryy.spotifymoodmatcher.ui.screens.PlaylistPreviewScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import android.app.Activity

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object MoodInput : Screen("mood_input")
    object PlaylistPreview : Screen("playlist_preview/{playlistId}") {
        fun createRoute(playlistId: String) = "playlist_preview/$playlistId"
    }
}

@Composable
fun NavGraph(
    navController: NavHostController,
    onLogout: () -> Unit,
    authManager: SpotifyAuthManager,
    activity: Activity
) {
    val isAuthenticated by authManager.isAuthenticated.collectAsState()

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(
                onNavigateToMoodInput = {
                    navController.navigate(Screen.MoodInput.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                },
                authManager = authManager,
                activity = activity
            )
        }

        composable(Screen.MoodInput.route) {
            MoodInputScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onPlaylistGenerated = { playlist ->
                    navController.navigate(Screen.PlaylistPreview.createRoute(playlist.id))
                }
            )
        }

        composable(
            route = Screen.PlaylistPreview.route,
        ) { backStackEntry ->
            val playlistId = backStackEntry.arguments?.getString("playlistId") ?: ""
            PlaylistPreviewScreen(
                playlistId = playlistId,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
} 