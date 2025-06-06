package com.annefryy.spotifymoodmatcher.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.annefryy.spotifymoodmatcher.data.spotify.PlaylistGenerator
import com.annefryy.spotifymoodmatcher.data.spotify.SpotifyPlaylist
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoodInputViewModel @Inject constructor(
    private val playlistGenerator: PlaylistGenerator
) : ViewModel() {

    private val _uiState = MutableStateFlow<MoodInputUiState>(MoodInputUiState.Initial)
    val uiState: StateFlow<MoodInputUiState> = _uiState.asStateFlow()

    fun generatePlaylist(moodInput: String) {
        viewModelScope.launch {
            _uiState.value = MoodInputUiState.Loading
            
            playlistGenerator.generatePlaylist(moodInput)
                .onSuccess { playlist ->
                    _uiState.value = MoodInputUiState.Success(playlist)
                }
                .onFailure { error ->
                    _uiState.value = MoodInputUiState.Error(error.message ?: "Failed to generate playlist")
                }
        }
    }

    fun resetState() {
        _uiState.value = MoodInputUiState.Initial
    }
}

sealed class MoodInputUiState {
    object Initial : MoodInputUiState()
    object Loading : MoodInputUiState()
    data class Success(val playlist: SpotifyPlaylist) : MoodInputUiState()
    data class Error(val message: String) : MoodInputUiState()
} 