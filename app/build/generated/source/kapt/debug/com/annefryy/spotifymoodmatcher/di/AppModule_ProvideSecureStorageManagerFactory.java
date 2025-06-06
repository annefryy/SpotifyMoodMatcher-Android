package com.annefryy.spotifymoodmatcher.di;

import android.content.Context;
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
public final class AppModule_ProvideSecureStorageManagerFactory implements Factory<SecureStorageManager> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideSecureStorageManagerFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public SecureStorageManager get() {
    return provideSecureStorageManager(contextProvider.get());
  }

  public static AppModule_ProvideSecureStorageManagerFactory create(
      Provider<Context> contextProvider) {
    return new AppModule_ProvideSecureStorageManagerFactory(contextProvider);
  }

  public static SecureStorageManager provideSecureStorageManager(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideSecureStorageManager(context));
  }
}
