package com.annefryy.spotifymoodmatcher.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.annefryy.spotifymoodmatcher.data.spotify.SpotifyApiService
import com.annefryy.spotifymoodmatcher.data.spotify.SpotifyPlaylist
import com.annefryy.spotifymoodmatcher.data.storage.SecureStorageManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlaylistPreviewViewModel @Inject constructor(
    private val spotifyApiService: SpotifyApiService,
    private val secureStorageManager: SecureStorageManager
) : ViewModel() {

    private val _uiState = MutableStateFlow<PlaylistPreviewUiState>(PlaylistPreviewUiState.Loading)
    val uiState: StateFlow<PlaylistPreviewUiState> = _uiState.asStateFlow()

    fun loadPlaylistDetails(playlistId: String) {
        viewModelScope.launch {
            try {
                val accessToken = secureStorageManager.getAccessToken() ?: throw Exception("Not authenticated")
                val authHeader = "Bearer $accessToken"

                // Get playlist details
                val playlistResponse = spotifyApiService.getPlaylistDetails(authHeader, playlistId)
                if (!playlistResponse.isSuccessful) {
                    throw Exception("Failed to load playlist: ${playlistResponse.code()}")
                }

                // Get playlist tracks
                val tracksResponse = spotifyApiService.getPlaylistTracks(authHeader, playlistId)
                if (!tracksResponse.isSuccessful) {
                    throw Exception("Failed to load tracks: ${tracksResponse.code()}")
                }

                val playlist = playlistResponse.body()!!
                val tracks = tracksResponse.body()?.items?.map { it.track } ?: emptyList()

                _uiState.value = PlaylistPreviewUiState.Success(
                    SpotifyPlaylist(
                        id = playlist.id,
                        name = playlist.name,
                        tracks = tracks
                    )
                )
            } catch (e: Exception) {
                _uiState.value = PlaylistPreviewUiState.Error(e.message ?: "Failed to load playlist")
            }
        }
    }

    fun savePlaylist(playlistId: String) {
        viewModelScope.launch {
            try {
                val accessToken = secureStorageManager.getAccessToken() ?: throw Exception("Not authenticated")
                val authHeader = "Bearer $accessToken"

                val response = spotifyApiService.savePlaylist(authHeader, playlistId)
                if (!response.isSuccessful) {
                    throw Exception("Failed to save playlist: ${response.code()}")
                }

                _uiState.value = (_uiState.value as? PlaylistPreviewUiState.Success)?.copy(
                    isSaved = true
                ) ?: _uiState.value
            } catch (e: Exception) {
                _uiState.value = PlaylistPreviewUiState.Error(e.message ?: "Failed to save playlist")
            }
        }
    }

    fun getSpotifyPlayIntent(playlistId: String): Intent {
        return Intent(Intent.ACTION_VIEW, Uri.parse("spotify:playlist:$playlistId"))
    }
}

sealed class PlaylistPreviewUiState {
    object Loading : PlaylistPreviewUiState()
    data class Success(
        val playlist: SpotifyPlaylist,
        val isSaved: Boolean = false
    ) : PlaylistPreviewUiState()
    data class Error(val message: String) : PlaylistPreviewUiState()
} 