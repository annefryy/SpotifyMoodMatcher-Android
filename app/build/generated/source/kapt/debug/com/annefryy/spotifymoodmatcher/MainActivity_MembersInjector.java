package com.annefryy.spotifymoodmatcher;

import com.annefryy.spotifymoodmatcher.data.auth.SpotifyAuthManager;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<SpotifyAuthManager> authManagerProvider;

  public MainActivity_MembersInjector(Provider<SpotifyAuthManager> authManagerProvider) {
    this.authManagerProvider = authManagerProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<SpotifyAuthManager> authManagerProvider) {
    return new MainActivity_MembersInjector(authManagerProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectAuthManager(instance, authManagerProvider.get());
  }

  @InjectedFieldSignature("com.annefryy.spotifymoodmatcher.MainActivity.authManager")
  public static void injectAuthManager(MainActivity instance, SpotifyAuthManager authManager) {
    instance.authManager = authManager;
  }
}
