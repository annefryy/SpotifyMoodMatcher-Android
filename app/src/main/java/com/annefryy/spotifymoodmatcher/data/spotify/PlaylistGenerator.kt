package com.annefryy.spotifymoodmatcher.data.spotify

import com.annefryy.spotifymoodmatcher.data.auth.SpotifyAuthManager
import com.annefryy.spotifymoodmatcher.data.storage.SecureStorageManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlaylistGenerator @Inject constructor(
    private val spotifyApiService: SpotifyApiService,
    private val authManager: SpotifyAuthManager,
    private val secureStorageManager: SecureStorageManager
) {
    suspend fun generatePlaylist(moodInput: String): Result<SpotifyPlaylist> = withContext(Dispatchers.IO) {
        try {
            val accessToken = secureStorageManager.getAccessToken() ?: return@withContext Result.failure(Exception("Not authenticated"))
            val authHeader = "Bearer $accessToken"

            // Search for tracks based on mood input
            val searchResponse = spotifyApiService.searchTracks(authHeader, moodInput)
            if (!searchResponse.isSuccessful) {
                return@withContext Result.failure(Exception("Failed to search tracks: ${searchResponse.code()}"))
            }
            val tracks = searchResponse.body()?.tracks?.items ?: emptyList()
            if (tracks.isEmpty()) {
                return@withContext Result.failure(Exception("No tracks found for mood: $moodInput"))
            }

            // Create a playlist
            val userId = "YOUR_USER_ID" // TODO: Fetch the user's Spotify ID
            val createPlaylistResponse = spotifyApiService.createPlaylist(
                authHeader,
                userId,
                CreatePlaylistRequest(name = "Mood: $moodInput")
            )
            if (!createPlaylistResponse.isSuccessful) {
                return@withContext Result.failure(Exception("Failed to create playlist: ${createPlaylistResponse.code()}"))
            }
            val playlistId = createPlaylistResponse.body()?.id ?: return@withContext Result.failure(Exception("No playlist ID returned"))

            // Add tracks to the playlist
            val trackUris = tracks.take(10).map { "spotify:track:${it.id}" }
            val addTracksResponse = spotifyApiService.addTracksToPlaylist(
                authHeader,
                playlistId,
                AddTracksRequest(trackUris)
            )
            if (!addTracksResponse.isSuccessful) {
                return@withContext Result.failure(Exception("Failed to add tracks: ${addTracksResponse.code()}"))
            }

            // Fetch playlist details for preview
            val playlistDetailsResponse = spotifyApiService.getPlaylistDetails(authHeader, playlistId)
            if (!playlistDetailsResponse.isSuccessful) {
                return@withContext Result.failure(Exception("Failed to fetch playlist details: ${playlistDetailsResponse.code()}"))
            }
            val playlistDetails = playlistDetailsResponse.body() ?: return@withContext Result.failure(Exception("No playlist details returned"))

            Result.success(SpotifyPlaylist(playlistDetails.id, playlistDetails.name, tracks))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
} 