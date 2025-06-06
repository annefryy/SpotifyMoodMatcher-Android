package com.annefryy.spotifymoodmatcher.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    onNavigateBack: () -> Unit,
    onLogout: () -> Unit
) {
    var darkMode by remember { mutableStateOf(false) }
    var highQuality by remember { mutableStateOf(true) }
    var dataSaver by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings") },
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
                .padding(16.dp)
        ) {
            // Appearance
            Text(
                text = "Appearance",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            ListItem(
                headlineContent = { Text("Dark Mode") },
                leadingContent = {
                    Icon(Icons.Default.Brightness4, contentDescription = null)
                },
                trailingContent = {
                    Switch(
                        checked = darkMode,
                        onCheckedChange = { darkMode = it }
                    )
                }
            )

            Divider()

            // Playback
            Text(
                text = "Playback",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            ListItem(
                headlineContent = { Text("High Quality Streaming") },
                leadingContent = {
                    Icon(Icons.Default.HighQuality, contentDescription = null)
                },
                trailingContent = {
                    Switch(
                        checked = highQuality,
                        onCheckedChange = { highQuality = it }
                    )
                }
            )

            ListItem(
                headlineContent = { Text("Data Saver") },
                leadingContent = {
                    Icon(Icons.Default.Speed, contentDescription = null)
                },
                trailingContent = {
                    Switch(
                        checked = dataSaver,
                        onCheckedChange = { dataSaver = it }
                    )
                }
            )

            Spacer(modifier = Modifier.weight(1f))

            // Logout button
            Button(
                onClick = onLogout,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.error
                )
            ) {
                Icon(
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = null,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text("Logout")
            }
        }
    }
} 