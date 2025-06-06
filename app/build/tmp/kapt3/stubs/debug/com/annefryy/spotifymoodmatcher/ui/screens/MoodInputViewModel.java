package com.annefryy.spotifymoodmatcher.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\rR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/annefryy/spotifymoodmatcher/ui/screens/MoodInputViewModel;", "Landroidx/lifecycle/ViewModel;", "playlistGenerator", "Lcom/annefryy/spotifymoodmatcher/data/spotify/PlaylistGenerator;", "(Lcom/annefryy/spotifymoodmatcher/data/spotify/PlaylistGenerator;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/annefryy/spotifymoodmatcher/ui/screens/MoodInputUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "generatePlaylist", "", "moodInput", "", "resetState", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class MoodInputViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.annefryy.spotifymoodmatcher.data.spotify.PlaylistGenerator playlistGenerator = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.annefryy.spotifymoodmatcher.ui.screens.MoodInputUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.annefryy.spotifymoodmatcher.ui.screens.MoodInputUiState> uiState = null;
    
    @javax.inject.Inject()
    public MoodInputViewModel(@org.jetbrains.annotations.NotNull()
    com.annefryy.spotifymoodmatcher.data.spotify.PlaylistGenerator playlistGenerator) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.annefryy.spotifymoodmatcher.ui.screens.MoodInputUiState> getUiState() {
        return null;
    }
    
    public final void generatePlaylist(@org.jetbrains.annotations.NotNull()
    java.lang.String moodInput) {
    }
    
    public final void resetState() {
    }
}