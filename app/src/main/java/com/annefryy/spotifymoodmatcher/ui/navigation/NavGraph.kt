package com.annefryy.spotifymoodmatcher.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.annefryy.spotifymoodmatcher.ui.screens.HomeScreen
import com.annefryy.spotifymoodmatcher.ui.screens.LoginScreen
import com.annefryy.spotifymoodmatcher.ui.screens.MoodInputScreen
import com.annefryy.spotifymoodmatcher.ui.screens.PlaylistPreviewScreen
import com.annefryy.spotifymoodmatcher.ui.screens.HistoryScreen
import com.annefryy.spotifymoodmatcher.ui.screens.SettingsScreen

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Home : Screen("home")
    object MoodInput : Screen("mood_input")
    object PlaylistPreview : Screen("playlist_preview/{playlistId}") {
        fun createRoute(playlistId: String) = "playlist_preview/$playlistId"
    }
    object History : Screen("history")
    object Settings : Screen("settings")
}

@Composable
fun NavGraph(
    navController: NavHostController,
    onLogout: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Home.route) {
            HomeScreen(
                onCreatePlaylist = { navController.navigate(Screen.MoodInput.route) },
                onViewHistory = { navController.navigate(Screen.History.route) },
                onSettings = { navController.navigate(Screen.Settings.route) }
            )
        }

        composable(Screen.MoodInput.route) {
            MoodInputScreen(
                onNavigateBack = { navController.popBackStack() },
                onPlaylistGenerated = { playlist ->
                    navController.navigate(Screen.PlaylistPreview.createRoute(playlist.id))
                }
            )
        }

        composable(Screen.PlaylistPreview.route + "/{playlistId}") { backStackEntry ->
            val playlistId = backStackEntry.arguments?.getString("playlistId") ?: ""
            PlaylistPreviewScreen(
                playlistId = playlistId,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(Screen.History.route) {
            HistoryScreen(
                onNavigateBack = { navController.popBackStack() },
                onPlaylistClick = { playlistId ->
                    navController.navigate(Screen.PlaylistPreview.createRoute(playlistId))
                }
            )
        }

        composable(Screen.Settings.route) {
            SettingsScreen(
                onNavigateBack = { navController.popBackStack() },
                onLogout = {
                    onLogout()
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Home.route) { inclusive = true }
                    }
                }
            )
        }
    }
} 