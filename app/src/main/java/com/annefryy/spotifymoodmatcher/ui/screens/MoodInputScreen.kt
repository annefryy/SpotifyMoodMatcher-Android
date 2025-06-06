package com.annefryy.spotifymoodmatcher.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.annefryy.spotifymoodmatcher.data.spotify.SpotifyPlaylist

@Composable
fun MoodInputScreen(
    onNavigateBack: () -> Unit,
    onPlaylistGenerated: (SpotifyPlaylist) -> Unit,
    viewModel: MoodInputViewModel = hiltViewModel()
) {
    var selectedMood by remember { mutableStateOf<String?>(null) }
    var selectedEmoji by remember { mutableStateOf<String?>(null) }
    var textInput by remember { mutableStateOf(TextFieldValue()) }
    var showError by remember { mutableStateOf(false) }

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val moods = listOf(
        "Happy", "Sad", "Energetic", "Relaxed",
        "Focused", "Romantic", "Nostalgic", "Motivated"
    )
    val emojis = listOf("😊", "😢", "😎", "😴", "💪", "❤️", "🎉", "🤔")

    LaunchedEffect(uiState) {
        when (uiState) {
            is MoodInputUiState.Success -> {
                onPlaylistGenerated((uiState as MoodInputUiState.Success).playlist)
            }
            else -> {}
        }
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
                text = "Select Your Mood",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
        }

        // Text Input
        OutlinedTextField(
            value = textInput,
            onValueChange = {
                if (it.text.length <= 50) {
                    textInput = it
                    showError = false
                } else {
                    showError = true
                }
                selectedMood = null
                selectedEmoji = null
            },
            label = { Text("Describe your mood or activity") },
            modifier = Modifier.fillMaxWidth(),
            isError = showError,
            singleLine = true,
            supportingText = {
                if (showError) Text("Max 50 characters", color = Color.Red)
            }
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Emoji Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            emojis.forEach { emoji ->
                Text(
                    text = emoji,
                    fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                    modifier = Modifier
                        .clickable {
                            selectedEmoji = emoji
                            selectedMood = null
                            textInput = TextFieldValue()
                            showError = false
                        }
                        .background(if (selectedEmoji == emoji) MaterialTheme.colorScheme.primary.copy(alpha = 0.2f) else Color.Transparent)
                        .padding(8.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))

        // Mood Grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(moods) { mood ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    onClick = {
                        selectedMood = mood
                        selectedEmoji = null
                        textInput = TextFieldValue()
                        showError = false
                    }
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = mood,
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Error Message
        if (uiState is MoodInputUiState.Error) {
            Text(
                text = (uiState as MoodInputUiState.Error).message,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        // Generate Button
        Button(
            onClick = {
                val input = when {
                    textInput.text.isNotBlank() -> textInput.text
                    selectedEmoji != null -> selectedEmoji!!
                    selectedMood != null -> selectedMood!!
                    else -> return@Button
                }
                viewModel.generatePlaylist(input)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            enabled = !showError && (textInput.text.isNotBlank() || selectedEmoji != null || selectedMood != null) && uiState !is MoodInputUiState.Loading
        ) {
            if (uiState is MoodInputUiState.Loading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            } else {
                Text("Generate Playlist")
            }
        }
    }
} 