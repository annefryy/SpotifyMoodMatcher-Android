package com.annefryy.spotifymoodmatcher.di

import android.content.Context
import com.annefryy.spotifymoodmatcher.data.auth.SpotifyAuthManager
import com.annefryy.spotifymoodmatcher.data.storage.SecureStorageManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    
    @Provides
    @Singleton
    fun provideSecureStorageManager(
        @ApplicationContext context: Context
    ): SecureStorageManager {
        return SecureStorageManager(context)
    }

    @Provides
    @Singleton
    fun provideSpotifyAuthManager(
        @ApplicationContext context: Context,
        secureStorageManager: SecureStorageManager
    ): SpotifyAuthManager {
        return SpotifyAuthManager(context, secureStorageManager)
    }
} 