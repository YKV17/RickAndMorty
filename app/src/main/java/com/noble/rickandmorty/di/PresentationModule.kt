package com.noble.rickandmorty.di

import com.noble.common_utils.coroutines.CoroutineContextProvider
import com.noble.common_utils.coroutines.CoroutineContextProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class PresentationModule {

    @Provides
    fun provideCoroutineContextProvider(coroutineContextProviderImpl: CoroutineContextProviderImpl): CoroutineContextProvider{
        return coroutineContextProviderImpl
    }
}