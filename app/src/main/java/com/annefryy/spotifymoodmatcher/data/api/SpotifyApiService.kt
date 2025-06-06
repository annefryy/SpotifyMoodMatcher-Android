package com.annefryy.spotifymoodmatcher.data.api

import retrofit2.http.*

interface SpotifyApiService {
    @GET("me")
    suspend fun getCurrentUser(): UserResponse

    @GET("me/playlists")
    suspend fun getUserPlaylists(
        @Query("limit") limit: Int = 50,
        @Query("offset") offset: Int = 0
    ): PlaylistsResponse

    @POST("users/{user_id}/playlists")
    suspend fun createPlaylist(
        @Path("user_id") userId: String,
        @Body playlist: CreatePlaylistRequest
    ): PlaylistResponse

    @POST("playlists/{playlist_id}/tracks")
    suspend fun addTracksToPlaylist(
        @Path("playlist_id") playlistId: String,
        @Body tracks: AddTracksRequest
    ): SnapshotResponse

    @GET("search")
    suspend fun searchTracks(
        @Query("q") query: String,
        @Query("type") type: String = "track",
        @Query("limit") limit: Int = 20
    ): SearchResponse
}

data class UserResponse(
    val id: String,
    val display_name: String,
    val email: String
)

data class PlaylistsResponse(
    val items: List<PlaylistResponse>,
    val total: Int
)

data class PlaylistResponse(
    val id: String,
    val name: String,
    val description: String?,
    val tracks: TracksReference
)

data class TracksReference(
    val total: Int
)

data class CreatePlaylistRequest(
    val name: String,
    val description: String,
    val public: Boolean = false
)

data class AddTracksRequest(
    val uris: List<String>
)

data class SnapshotResponse(
    val snapshot_id: String
)

data class SearchResponse(
    val tracks: TracksResponse
)

data class TracksResponse(
    val items: List<Track>,
    val total: Int
)

data class Track(
    val id: String,
    val name: String,
    val artists: List<Artist>,
    val album: Album,
    val uri: String
)

data class Artist(
    val id: String,
    val name: String
)

data class Album(
    val id: String,
    val name: String,
    val images: List<Image>
)

data class Image(
    val url: String,
    val height: Int?,
    val width: Int?
) 