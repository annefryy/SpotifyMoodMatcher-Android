package com.annefryy.spotifymoodmatcher.data.spotify;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0010"}, d2 = {"Lcom/annefryy/spotifymoodmatcher/data/spotify/PlaylistGenerator;", "", "spotifyApiService", "Lcom/annefryy/spotifymoodmatcher/data/spotify/SpotifyApiService;", "authManager", "Lcom/annefryy/spotifymoodmatcher/data/auth/SpotifyAuthManager;", "secureStorageManager", "Lcom/annefryy/spotifymoodmatcher/data/storage/SecureStorageManager;", "(Lcom/annefryy/spotifymoodmatcher/data/spotify/SpotifyApiService;Lcom/annefryy/spotifymoodmatcher/data/auth/SpotifyAuthManager;Lcom/annefryy/spotifymoodmatcher/data/storage/SecureStorageManager;)V", "generatePlaylist", "Lkotlin/Result;", "Lcom/annefryy/spotifymoodmatcher/data/spotify/SpotifyPlaylist;", "moodInput", "", "generatePlaylist-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class PlaylistGenerator {
    @org.jetbrains.annotations.NotNull()
    private final com.annefryy.spotifymoodmatcher.data.spotify.SpotifyApiService spotifyApiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.annefryy.spotifymoodmatcher.data.auth.SpotifyAuthManager authManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.annefryy.spotifymoodmatcher.data.storage.SecureStorageManager secureStorageManager = null;
    
    @javax.inject.Inject()
    public PlaylistGenerator(@org.jetbrains.annotations.NotNull()
    com.annefryy.spotifymoodmatcher.data.spotify.SpotifyApiService spotifyApiService, @org.jetbrains.annotations.NotNull()
    com.annefryy.spotifymoodmatcher.data.auth.SpotifyAuthManager authManager, @org.jetbrains.annotations.NotNull()
    com.annefryy.spotifymoodmatcher.data.storage.SecureStorageManager secureStorageManager) {
        super();
    }
}