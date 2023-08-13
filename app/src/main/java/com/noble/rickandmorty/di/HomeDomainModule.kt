package com.noble.rickandmorty.di

import com.noble.home_domain.use_cases.GetCharacterListUseCase
import com.noble.home_domain.use_cases.GetCharacterListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeDomainModule {
    @Binds
    abstract fun provideGetCharacterListUseCase(getCharacterListUseCaseImpl: GetCharacterListUseCaseImpl): GetCharacterListUseCase

}