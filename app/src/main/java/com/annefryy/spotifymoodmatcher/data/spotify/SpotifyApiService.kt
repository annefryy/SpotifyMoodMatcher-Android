package com.annefryy.spotifymoodmatcher.data.spotify

import retrofit2.http.*
import retrofit2.Response

// Data models (simplified for now)
data class SpotifyTrack(val id: String, val name: String, val artists: List<SpotifyArtist>)
data class SpotifyArtist(val name: String)
data class SpotifyPlaylist(val id: String, val name: String, val tracks: List<SpotifyTrack>?)
data class SearchTracksResponse(val tracks: Tracks)
data class Tracks(val items: List<SpotifyTrack>)
data class CreatePlaylistRequest(val name: String, val description: String = "", val public: Boolean = false)
data class CreatePlaylistResponse(val id: String, val name: String)

data class AddTracksRequest(val uris: List<String>)

data class PlaylistDetailsResponse(val id: String, val name: String, val tracks: Tracks)

data class UserProfile(
    val id: String,
    val displayName: String
)

interface SpotifyApiService {
    @GET("v1/search")
    suspend fun searchTracks(
        @Header("Authorization") authHeader: String,
        @Query("q") query: String,
        @Query("type") type: String = "track",
        @Query("limit") limit: Int = 20
    ): Response<SearchTracksResponse>

    @POST("v1/users/{user_id}/playlists")
    suspend fun createPlaylist(
        @Header("Authorization") authHeader: String,
        @Path("user_id") userId: String,
        @Body body: CreatePlaylistRequest
    ): Response<CreatePlaylistResponse>

    @POST("v1/playlists/{playlist_id}/tracks")
    suspend fun addTracksToPlaylist(
        @Header("Authorization") authHeader: String,
        @Path("playlist_id") playlistId: String,
        @Body body: AddTracksRequest
    ): Response<Unit>

    @GET("v1/playlists/{playlist_id}")
    suspend fun getPlaylistDetails(
        @Header("Authorization") authHeader: String,
        @Path("playlist_id") playlistId: String
    ): Response<PlaylistDetailsResponse>

    @GET("v1/me")
    suspend fun getUserProfile(
        @Header("Authorization") authHeader: String
    ): Response<UserProfile>

    @PUT("v1/playlists/{playlist_id}/followers")
    suspend fun savePlaylist(
        @Header("Authorization") authHeader: String,
        @Path("playlist_id") playlistId: String
    ): Response<Unit>

    @GET("v1/playlists/{playlist_id}/tracks")
    suspend fun getPlaylistTracks(
        @Header("Authorization") authHeader: String,
        @Path("playlist_id") playlistId: String
    ): Response<PlaylistTracksResponse>
}

data class PlaylistTracksResponse(
    val items: List<PlaylistTrackItem>
)

data class PlaylistTrackItem(
    val track: SpotifyTrack
) 