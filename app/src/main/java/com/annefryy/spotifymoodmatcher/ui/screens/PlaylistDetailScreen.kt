package com.annefryy.spotifymoodmatcher.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaylistDetailScreen(
    playlistId: String,
    onNavigateBack: () -> Unit
) {
    // Mock data for demonstration
    val tracks = remember {
        listOf(
            Track("1", "Song 1", "Artist 1", "3:30"),
            Track("2", "Song 2", "Artist 2", "4:15"),
            Track("3", "Song 3", "Artist 3", "3:45")
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Playlist Details") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Playback controls
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* TODO: Implement previous track */ }) {
                    Icon(Icons.Default.FastRewind, contentDescription = "Previous track")
                }
                IconButton(onClick = { /* TODO: Implement play/pause */ }) {
                    Icon(Icons.Default.PlayArrow, contentDescription = "Play")
                }
                IconButton(onClick = { /* TODO: Implement next track */ }) {
                    Icon(Icons.Default.FastForward, contentDescription = "Next track")
                }
            }

            // Track list
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(tracks) { track ->
                    TrackItem(track = track)
                }
            }
        }
    }
}

@Composable
private fun TrackItem(track: Track) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = null,
                modifier = Modifier.padding(end = 16.dp)
            )
            Column {
                Text(
                    text = track.title,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = track.artist,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Text(
                text = track.duration,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

data class Track(
    val id: String,
    val title: String,
    val artist: String,
    val duration: String
) 