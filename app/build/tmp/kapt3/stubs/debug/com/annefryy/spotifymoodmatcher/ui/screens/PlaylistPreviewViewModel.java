package com.annefryy.spotifymoodmatcher.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lcom/annefryy/spotifymoodmatcher/ui/screens/PlaylistPreviewViewModel;", "Landroidx/lifecycle/ViewModel;", "spotifyApiService", "Lcom/annefryy/spotifymoodmatcher/data/spotify/SpotifyApiService;", "secureStorageManager", "Lcom/annefryy/spotifymoodmatcher/data/storage/SecureStorageManager;", "(Lcom/annefryy/spotifymoodmatcher/data/spotify/SpotifyApiService;Lcom/annefryy/spotifymoodmatcher/data/storage/SecureStorageManager;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/annefryy/spotifymoodmatcher/ui/screens/PlaylistPreviewUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "getSpotifyPlayIntent", "Landroid/content/Intent;", "playlistId", "", "loadPlaylistDetails", "", "savePlaylist", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class PlaylistPreviewViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.annefryy.spotifymoodmatcher.data.spotify.SpotifyApiService spotifyApiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.annefryy.spotifymoodmatcher.data.storage.SecureStorageManager secureStorageManager = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.annefryy.spotifymoodmatcher.ui.screens.PlaylistPreviewUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.annefryy.spotifymoodmatcher.ui.screens.PlaylistPreviewUiState> uiState = null;
    
    @javax.inject.Inject()
    public PlaylistPreviewViewModel(@org.jetbrains.annotations.NotNull()
    com.annefryy.spotifymoodmatcher.data.spotify.SpotifyApiService spotifyApiService, @org.jetbrains.annotations.NotNull()
    com.annefryy.spotifymoodmatcher.data.storage.SecureStorageManager secureStorageManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.annefryy.spotifymoodmatcher.ui.screens.PlaylistPreviewUiState> getUiState() {
        return null;
    }
    
    public final void loadPlaylistDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String playlistId) {
    }
    
    public final void savePlaylist(@org.jetbrains.annotations.NotNull()
    java.lang.String playlistId) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Intent getSpotifyPlayIntent(@org.jetbrains.annotations.NotNull()
    java.lang.String playlistId) {
        return null;
    }
}