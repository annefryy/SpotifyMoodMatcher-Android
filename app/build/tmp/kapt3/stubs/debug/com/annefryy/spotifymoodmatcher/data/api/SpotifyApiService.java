package com.annefryy.spotifymoodmatcher.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\"\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u0010H\u00a7@\u00a2\u0006\u0002\u0010\u0011J\"\u0010\u0012\u001a\u00020\u00132\b\b\u0003\u0010\u0014\u001a\u00020\u00152\b\b\u0003\u0010\u0016\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010\u0017J,\u0010\u0018\u001a\u00020\u00192\b\b\u0001\u0010\u001a\u001a\u00020\u00052\b\b\u0003\u0010\u001b\u001a\u00020\u00052\b\b\u0003\u0010\u0014\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010\u001c\u00a8\u0006\u001d"}, d2 = {"Lcom/annefryy/spotifymoodmatcher/data/api/SpotifyApiService;", "", "addTracksToPlaylist", "Lcom/annefryy/spotifymoodmatcher/data/api/SnapshotResponse;", "playlistId", "", "tracks", "Lcom/annefryy/spotifymoodmatcher/data/api/AddTracksRequest;", "(Ljava/lang/String;Lcom/annefryy/spotifymoodmatcher/data/api/AddTracksRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createPlaylist", "Lcom/annefryy/spotifymoodmatcher/data/api/PlaylistResponse;", "userId", "playlist", "Lcom/annefryy/spotifymoodmatcher/data/api/CreatePlaylistRequest;", "(Ljava/lang/String;Lcom/annefryy/spotifymoodmatcher/data/api/CreatePlaylistRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentUser", "Lcom/annefryy/spotifymoodmatcher/data/api/UserResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserPlaylists", "Lcom/annefryy/spotifymoodmatcher/data/api/PlaylistsResponse;", "limit", "", "offset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchTracks", "Lcom/annefryy/spotifymoodmatcher/data/api/SearchResponse;", "query", "type", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface SpotifyApiService {
    
    @retrofit2.http.GET(value = "me")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCurrentUser(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.annefryy.spotifymoodmatcher.data.api.UserResponse> $completion);
    
    @retrofit2.http.GET(value = "me/playlists")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserPlaylists(@retrofit2.http.Query(value = "limit")
    int limit, @retrofit2.http.Query(value = "offset")
    int offset, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.annefryy.spotifymoodmatcher.data.api.PlaylistsResponse> $completion);
    
    @retrofit2.http.POST(value = "users/{user_id}/playlists")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createPlaylist(@retrofit2.http.Path(value = "user_id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.annefryy.spotifymoodmatcher.data.api.CreatePlaylistRequest playlist, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.annefryy.spotifymoodmatcher.data.api.PlaylistResponse> $completion);
    
    @retrofit2.http.POST(value = "playlists/{playlist_id}/tracks")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addTracksToPlaylist(@retrofit2.http.Path(value = "playlist_id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String playlistId, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.annefryy.spotifymoodmatcher.data.api.AddTracksRequest tracks, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.annefryy.spotifymoodmatcher.data.api.SnapshotResponse> $completion);
    
    @retrofit2.http.GET(value = "search")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchTracks(@retrofit2.http.Query(value = "q")
    @org.jetbrains.annotations.NotNull()
    java.lang.String query, @retrofit2.http.Query(value = "type")
    @org.jetbrains.annotations.NotNull()
    java.lang.String type, @retrofit2.http.Query(value = "limit")
    int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.annefryy.spotifymoodmatcher.data.api.SearchResponse> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}