package com.annefryy.spotifymoodmatcher.di;

import com.annefryy.spotifymoodmatcher.data.spotify.SpotifyApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

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
public final class SpotifyApiModule_ProvideSpotifyApiServiceFactory implements Factory<SpotifyApiService> {
  private final Provider<Retrofit> retrofitProvider;

  public SpotifyApiModule_ProvideSpotifyApiServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public SpotifyApiService get() {
    return provideSpotifyApiService(retrofitProvider.get());
  }

  public static SpotifyApiModule_ProvideSpotifyApiServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new SpotifyApiModule_ProvideSpotifyApiServiceFactory(retrofitProvider);
  }

  public static SpotifyApiService provideSpotifyApiService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(SpotifyApiModule.INSTANCE.provideSpotifyApiService(retrofit));
  }
}
