package com.annefryy.spotifymoodmatcher.data.spotify;

import com.annefryy.spotifymoodmatcher.data.auth.SpotifyAuthManager;
import com.annefryy.spotifymoodmatcher.data.storage.SecureStorageManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class PlaylistGenerator_Factory implements Factory<PlaylistGenerator> {
  private final Provider<SpotifyApiService> spotifyApiServiceProvider;

  private final Provider<SpotifyAuthManager> authManagerProvider;

  private final Provider<SecureStorageManager> secureStorageManagerProvider;

  public PlaylistGenerator_Factory(Provider<SpotifyApiService> spotifyApiServiceProvider,
      Provider<SpotifyAuthManager> authManagerProvider,
      Provider<SecureStorageManager> secureStorageManagerProvider) {
    this.spotifyApiServiceProvider = spotifyApiServiceProvider;
    this.authManagerProvider = authManagerProvider;
    this.secureStorageManagerProvider = secureStorageManagerProvider;
  }

  @Override
  public PlaylistGenerator get() {
    return newInstance(spotifyApiServiceProvider.get(), authManagerProvider.get(), secureStorageManagerProvider.get());
  }

  public static PlaylistGenerator_Factory create(
      Provider<SpotifyApiService> spotifyApiServiceProvider,
      Provider<SpotifyAuthManager> authManagerProvider,
      Provider<SecureStorageManager> secureStorageManagerProvider) {
    return new PlaylistGenerator_Factory(spotifyApiServiceProvider, authManagerProvider, secureStorageManagerProvider);
  }

  public static PlaylistGenerator newInstance(SpotifyApiService spotifyApiService,
      SpotifyAuthManager authManager, SecureStorageManager secureStorageManager) {
    return new PlaylistGenerator(spotifyApiService, authManager, secureStorageManager);
  }
}
