package com.annefryy.spotifymoodmatcher.data.spotify;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ2\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0012J(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0017J(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0012J<\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u001b\u001a\u00020\u00062\b\b\u0003\u0010\u001c\u001a\u00020\u00062\b\b\u0003\u0010\u001d\u001a\u00020\u001eH\u00a7@\u00a2\u0006\u0002\u0010\u001f\u00a8\u0006 "}, d2 = {"Lcom/annefryy/spotifymoodmatcher/data/spotify/SpotifyApiService;", "", "addTracksToPlaylist", "Lretrofit2/Response;", "", "authHeader", "", "playlistId", "body", "Lcom/annefryy/spotifymoodmatcher/data/spotify/AddTracksRequest;", "(Ljava/lang/String;Ljava/lang/String;Lcom/annefryy/spotifymoodmatcher/data/spotify/AddTracksRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createPlaylist", "Lcom/annefryy/spotifymoodmatcher/data/spotify/CreatePlaylistResponse;", "userId", "Lcom/annefryy/spotifymoodmatcher/data/spotify/CreatePlaylistRequest;", "(Ljava/lang/String;Ljava/lang/String;Lcom/annefryy/spotifymoodmatcher/data/spotify/CreatePlaylistRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlaylistDetails", "Lcom/annefryy/spotifymoodmatcher/data/spotify/PlaylistDetailsResponse;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlaylistTracks", "Lcom/annefryy/spotifymoodmatcher/data/spotify/PlaylistTracksResponse;", "getUserProfile", "Lcom/annefryy/spotifymoodmatcher/data/spotify/UserProfile;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePlaylist", "searchTracks", "Lcom/annefryy/spotifymoodmatcher/data/spotify/SearchTracksResponse;", "query", "type", "limit", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface SpotifyApiService {
    
    @retrofit2.http.GET(value = "v1/search")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchTracks(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String authHeader, @retrofit2.http.Query(value = "q")
    @org.jetbrains.annotations.NotNull()
    java.lang.String query, @retrofit2.http.Query(value = "type")
    @org.jetbrains.annotations.NotNull()
    java.lang.String type, @retrofit2.http.Query(value = "limit")
    int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.annefryy.spotifymoodmatcher.data.spotify.SearchTracksResponse>> $completion);
    
    @retrofit2.http.POST(value = "v1/users/{user_id}/playlists")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createPlaylist(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String authHeader, @retrofit2.http.Path(value = "user_id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.annefryy.spotifymoodmatcher.data.spotify.CreatePlaylistRequest body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.annefryy.spotifymoodmatcher.data.spotify.CreatePlaylistResponse>> $completion);
    
    @retrofit2.http.POST(value = "v1/playlists/{playlist_id}/tracks")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addTracksToPlaylist(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String authHeader, @retrofit2.http.Path(value = "playlist_id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String playlistId, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.annefryy.spotifymoodmatcher.data.spotify.AddTracksRequest body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.GET(value = "v1/playlists/{playlist_id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPlaylistDetails(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String authHeader, @retrofit2.http.Path(value = "playlist_id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String playlistId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.annefryy.spotifymoodmatcher.data.spotify.PlaylistDetailsResponse>> $completion);
    
    @retrofit2.http.GET(value = "v1/me")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserProfile(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String authHeader, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.annefryy.spotifymoodmatcher.data.spotify.UserProfile>> $completion);
    
    @retrofit2.http.PUT(value = "v1/playlists/{playlist_id}/followers")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object savePlaylist(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String authHeader, @retrofit2.http.Path(value = "playlist_id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String playlistId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.GET(value = "v1/playlists/{playlist_id}/tracks")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPlaylistTracks(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String authHeader, @retrofit2.http.Path(value = "playlist_id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String playlistId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.annefryy.spotifymoodmatcher.data.spotify.PlaylistTracksResponse>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}