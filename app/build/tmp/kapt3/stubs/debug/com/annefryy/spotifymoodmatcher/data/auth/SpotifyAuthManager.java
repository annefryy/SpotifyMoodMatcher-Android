package com.annefryy.spotifymoodmatcher.data.auth;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001bB\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0082@\u00a2\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\bJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@\u00a2\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0011J\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u0017R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/annefryy/spotifymoodmatcher/data/auth/SpotifyAuthManager;", "", "context", "Landroid/content/Context;", "secureStorageManager", "Lcom/annefryy/spotifymoodmatcher/data/storage/SecureStorageManager;", "(Landroid/content/Context;Lcom/annefryy/spotifymoodmatcher/data/storage/SecureStorageManager;)V", "TAG", "", "client", "Lokhttp3/OkHttpClient;", "exchangeCodeForToken", "Lcom/annefryy/spotifymoodmatcher/data/auth/SpotifyAuthManager$TokenResponse;", "code", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAuthUrl", "handleAuthResponse", "", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAuthenticated", "logout", "", "refreshToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startAuth", "TokenResponse", "app_debug"})
public final class SpotifyAuthManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.annefryy.spotifymoodmatcher.data.storage.SecureStorageManager secureStorageManager = null;
    @org.jetbrains.annotations.NotNull()
    private final okhttp3.OkHttpClient client = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "SpotifyAuthManager";
    
    @javax.inject.Inject()
    public SpotifyAuthManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.annefryy.spotifymoodmatcher.data.storage.SecureStorageManager secureStorageManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAuthUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object handleAuthResponse(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final java.lang.Object exchangeCodeForToken(java.lang.String code, kotlin.coroutines.Continuation<? super com.annefryy.spotifymoodmatcher.data.auth.SpotifyAuthManager.TokenResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object refreshToken(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    public final void startAuth() {
    }
    
    public final boolean isAuthenticated() {
        return false;
    }
    
    public final void logout() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0016"}, d2 = {"Lcom/annefryy/spotifymoodmatcher/data/auth/SpotifyAuthManager$TokenResponse;", "", "accessToken", "", "refreshToken", "expiresIn", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getAccessToken", "()Ljava/lang/String;", "getExpiresIn", "()I", "getRefreshToken", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
    public static final class TokenResponse {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String accessToken = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String refreshToken = null;
        private final int expiresIn = 0;
        
        public TokenResponse(@org.jetbrains.annotations.NotNull()
        java.lang.String accessToken, @org.jetbrains.annotations.Nullable()
        java.lang.String refreshToken, int expiresIn) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAccessToken() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getRefreshToken() {
            return null;
        }
        
        public final int getExpiresIn() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component2() {
            return null;
        }
        
        public final int component3() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.annefryy.spotifymoodmatcher.data.auth.SpotifyAuthManager.TokenResponse copy(@org.jetbrains.annotations.NotNull()
        java.lang.String accessToken, @org.jetbrains.annotations.Nullable()
        java.lang.String refreshToken, int expiresIn) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}