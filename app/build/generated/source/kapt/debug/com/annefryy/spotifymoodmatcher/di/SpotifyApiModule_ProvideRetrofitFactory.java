package com.annefryy.spotifymoodmatcher.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
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
public final class SpotifyApiModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final Provider<OkHttpClient> clientProvider;

  public SpotifyApiModule_ProvideRetrofitFactory(Provider<OkHttpClient> clientProvider) {
    this.clientProvider = clientProvider;
  }

  @Override
  public Retrofit get() {
    return provideRetrofit(clientProvider.get());
  }

  public static SpotifyApiModule_ProvideRetrofitFactory create(
      Provider<OkHttpClient> clientProvider) {
    return new SpotifyApiModule_ProvideRetrofitFactory(clientProvider);
  }

  public static Retrofit provideRetrofit(OkHttpClient client) {
    return Preconditions.checkNotNullFromProvides(SpotifyApiModule.INSTANCE.provideRetrofit(client));
  }
}
