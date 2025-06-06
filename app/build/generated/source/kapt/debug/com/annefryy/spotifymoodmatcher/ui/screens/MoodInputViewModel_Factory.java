package com.annefryy.spotifymoodmatcher.ui.screens;

import com.annefryy.spotifymoodmatcher.data.spotify.PlaylistGenerator;
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
public final class MoodInputViewModel_Factory implements Factory<MoodInputViewModel> {
  private final Provider<PlaylistGenerator> playlistGeneratorProvider;

  public MoodInputViewModel_Factory(Provider<PlaylistGenerator> playlistGeneratorProvider) {
    this.playlistGeneratorProvider = playlistGeneratorProvider;
  }

  @Override
  public MoodInputViewModel get() {
    return newInstance(playlistGeneratorProvider.get());
  }

  public static MoodInputViewModel_Factory create(
      Provider<PlaylistGenerator> playlistGeneratorProvider) {
    return new MoodInputViewModel_Factory(playlistGeneratorProvider);
  }

  public static MoodInputViewModel newInstance(PlaylistGenerator playlistGenerator) {
    return new MoodInputViewModel(playlistGenerator);
  }
}
