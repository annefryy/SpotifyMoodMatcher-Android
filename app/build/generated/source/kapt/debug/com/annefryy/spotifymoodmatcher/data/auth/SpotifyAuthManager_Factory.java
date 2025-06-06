package com.annefryy.spotifymoodmatcher.data.auth;

import android.content.Context;
import com.annefryy.spotifymoodmatcher.data.storage.SecureStorageManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class SpotifyAuthManager_Factory implements Factory<SpotifyAuthManager> {
  private final Provider<Context> contextProvider;

  private final Provider<SecureStorageManager> secureStorageManagerProvider;

  public SpotifyAuthManager_Factory(Provider<Context> contextProvider,
      Provider<SecureStorageManager> secureStorageManagerProvider) {
    this.contextProvider = contextProvider;
    this.secureStorageManagerProvider = secureStorageManagerProvider;
  }

  @Override
  public SpotifyAuthManager get() {
    return newInstance(contextProvider.get(), secureStorageManagerProvider.get());
  }

  public static SpotifyAuthManager_Factory create(Provider<Context> contextProvider,
      Provider<SecureStorageManager> secureStorageManagerProvider) {
    return new SpotifyAuthManager_Factory(contextProvider, secureStorageManagerProvider);
  }

  public static SpotifyAuthManager newInstance(Context context,
      SecureStorageManager secureStorageManager) {
    return new SpotifyAuthManager(context, secureStorageManager);
  }
}
