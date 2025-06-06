package com.annefryy.spotifymoodmatcher.auth;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/annefryy/spotifymoodmatcher/auth/SpotifyCallbackActivity;", "Landroidx/activity/ComponentActivity;", "()V", "authManager", "Lcom/annefryy/spotifymoodmatcher/data/auth/SpotifyAuthManager;", "getAuthManager", "()Lcom/annefryy/spotifymoodmatcher/data/auth/SpotifyAuthManager;", "setAuthManager", "(Lcom/annefryy/spotifymoodmatcher/data/auth/SpotifyAuthManager;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class SpotifyCallbackActivity extends androidx.activity.ComponentActivity {
    @javax.inject.Inject()
    public com.annefryy.spotifymoodmatcher.data.auth.SpotifyAuthManager authManager;
    
    public SpotifyCallbackActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.annefryy.spotifymoodmatcher.data.auth.SpotifyAuthManager getAuthManager() {
        return null;
    }
    
    public final void setAuthManager(@org.jetbrains.annotations.NotNull()
    com.annefryy.spotifymoodmatcher.data.auth.SpotifyAuthManager p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
}