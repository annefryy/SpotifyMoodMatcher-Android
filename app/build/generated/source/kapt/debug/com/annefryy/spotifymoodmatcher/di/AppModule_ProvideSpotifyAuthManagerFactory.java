package com.annefryy.spotifymoodmatcher.di;

import android.content.Context;
import com.annefryy.spotifymoodmatcher.data.auth.SpotifyAuthManager;
import com.annefryy.spotifymoodmatcher.data.storage.SecureStorageManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class AppModule_ProvideSpotifyAuthManagerFactory implements Factory<SpotifyAuthManager> {
  private final Provider<Context> contextProvider;

  private final Provider<SecureStorageManager> secureStorageManagerProvider;

  public AppModule_ProvideSpotifyAuthManagerFactory(Provider<Context> contextProvider,
      Provider<SecureStorageManager> secureStorageManagerProvider) {
    this.contextProvider = contextProvider;
    this.secureStorageManagerProvider = secureStorageManagerProvider;
  }

  @Override
  public SpotifyAuthManager get() {
    return provideSpotifyAuthManager(contextProvider.get(), secureStorageManagerProvider.get());
  }

  public static AppModule_ProvideSpotifyAuthManagerFactory create(Provider<Context> contextProvider,
      Provider<SecureStorageManager> secureStorageManagerProvider) {
    return new AppModule_ProvideSpotifyAuthManagerFactory(contextProvider, secureStorageManagerProvider);
  }

  public static SpotifyAuthManager provideSpotifyAuthManager(Context context,
      SecureStorageManager secureStorageManager) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideSpotifyAuthManager(context, secureStorageManager));
  }
}
