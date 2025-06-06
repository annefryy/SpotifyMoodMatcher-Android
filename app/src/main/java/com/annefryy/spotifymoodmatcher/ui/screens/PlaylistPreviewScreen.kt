package com.annefryy.spotifymoodmatcher.ui.screens

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.annefryy.spotifymoodmatcher.data.spotify.SpotifyPlaylist
import com.annefryy.spotifymoodmatcher.data.spotify.SpotifyTrack

@Composable
fun PlaylistPreviewScreen(
    playlistId: String,
    onNavigateBack: () -> Unit,
    viewModel: PlaylistPreviewViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(playlistId) {
        viewModel.loadPlaylistDetails(playlistId)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Top Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onNavigateBack) {
                Icon(Icons.Default.ArrowBack, "Back")
            }
            Text(
                text = "Playlist Preview",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
        }

        when (uiState) {
            is PlaylistPreviewUiState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            is PlaylistPreviewUiState.Error -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = (uiState as PlaylistPreviewUiState.Error).message,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
            is PlaylistPreviewUiState.Success -> {
                val playlist = (uiState as PlaylistPreviewUiState.Success).playlist
                val isSaved = (uiState as PlaylistPreviewUiState.Success).isSaved

                // Playlist Name
                Text(
                    text = playlist.name,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // Track List
                LazyColumn(
                    modifier = Modifier.weight(1f)
                ) {
                    items(playlist.tracks ?: emptyList()) { track ->
                        TrackItem(track = track)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Action Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = {
                            context.startActivity(viewModel.getSpotifyPlayIntent(playlistId))
                        },
                        modifier = Modifier.weight(1f).padding(end = 8.dp)
                    ) {
                        Icon(Icons.Default.PlayArrow, contentDescription = "Play")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Play")
                    }
                    Button(
                        onClick = { viewModel.savePlaylist(playlistId) },
                        modifier = Modifier.weight(1f).padding(start = 8.dp),
                        enabled = !isSaved
                    ) {
                        Icon(Icons.Default.Save, contentDescription = "Save")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(if (isSaved) "Saved" else "Save")
                    }
                }
            }
        }
    }
}

@Composable
fun TrackItem(track: SpotifyTrack) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = track.name,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = track.artists.joinToString(", ") { it.name },
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f)
        )
    }
} 