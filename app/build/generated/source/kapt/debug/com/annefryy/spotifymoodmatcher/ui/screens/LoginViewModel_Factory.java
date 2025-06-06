package com.annefryy.spotifymoodmatcher.ui.screens;

import com.annefryy.spotifymoodmatcher.data.auth.SpotifyAuthManager;
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
public final class LoginViewModel_Factory implements Factory<LoginViewModel> {
  private final Provider<SpotifyAuthManager> authManagerProvider;

  public LoginViewModel_Factory(Provider<SpotifyAuthManager> authManagerProvider) {
    this.authManagerProvider = authManagerProvider;
  }

  @Override
  public LoginViewModel get() {
    return newInstance(authManagerProvider.get());
  }

  public static LoginViewModel_Factory create(Provider<SpotifyAuthManager> authManagerProvider) {
    return new LoginViewModel_Factory(authManagerProvider);
  }

  public static LoginViewModel newInstance(SpotifyAuthManager authManager) {
    return new LoginViewModel(authManager);
  }
}
