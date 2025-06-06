package com.annefryy.spotifymoodmatcher.auth;

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
public final class SpotifyCallbackActivity_MembersInjector implements MembersInjector<SpotifyCallbackActivity> {
  private final Provider<SpotifyAuthManager> authManagerProvider;

  public SpotifyCallbackActivity_MembersInjector(Provider<SpotifyAuthManager> authManagerProvider) {
    this.authManagerProvider = authManagerProvider;
  }

  public static MembersInjector<SpotifyCallbackActivity> create(
      Provider<SpotifyAuthManager> authManagerProvider) {
    return new SpotifyCallbackActivity_MembersInjector(authManagerProvider);
  }

  @Override
  public void injectMembers(SpotifyCallbackActivity instance) {
    injectAuthManager(instance, authManagerProvider.get());
  }

  @InjectedFieldSignature("com.annefryy.spotifymoodmatcher.auth.SpotifyCallbackActivity.authManager")
  public static void injectAuthManager(SpotifyCallbackActivity instance,
      SpotifyAuthManager authManager) {
    instance.authManager = authManager;
  }
}
