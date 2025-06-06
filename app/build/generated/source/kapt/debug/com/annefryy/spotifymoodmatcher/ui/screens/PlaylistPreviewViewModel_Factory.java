package com.annefryy.spotifymoodmatcher.ui.screens;

import com.annefryy.spotifymoodmatcher.data.spotify.SpotifyApiService;
import com.annefryy.spotifymoodmatcher.data.storage.SecureStorageManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class PlaylistPreviewViewModel_Factory implements Factory<PlaylistPreviewViewModel> {
  private final Provider<SpotifyApiService> spotifyApiServiceProvider;

  private final Provider<SecureStorageManager> secureStorageManagerProvider;

  public PlaylistPreviewViewModel_Factory(Provider<SpotifyApiService> spotifyApiServiceProvider,
      Provider<SecureStorageManager> secureStorageManagerProvider) {
    this.spotifyApiServiceProvider = spotifyApiServiceProvider;
    this.secureStorageManagerProvider = secureStorageManagerProvider;
  }

  @Override
  public PlaylistPreviewViewModel get() {
    return newInstance(spotifyApiServiceProvider.get(), secureStorageManagerProvider.get());
  }

  public static PlaylistPreviewViewModel_Factory create(
      Provider<SpotifyApiService> spotifyApiServiceProvider,
      Provider<SecureStorageManager> secureStorageManagerProvider) {
    return new PlaylistPreviewViewModel_Factory(spotifyApiServiceProvider, secureStorageManagerProvider);
  }

  public static PlaylistPreviewViewModel newInstance(SpotifyApiService spotifyApiService,
      SecureStorageManager secureStorageManager) {
    return new PlaylistPreviewViewModel(spotifyApiService, secureStorageManager);
  }
}
