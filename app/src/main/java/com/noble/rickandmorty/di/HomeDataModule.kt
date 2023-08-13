package com.noble.rickandmorty.di

import com.noble.home_data.network.CharacterService
import com.noble.home_data.repository.CharacterRepositoryImpl
import com.noble.home_domain.repository.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class HomeDataModule {

    @Provides
    fun provideCharacterService(retrofit: Retrofit): CharacterService {
        return retrofit.create(CharacterService::class.java)
    }

    @Provides
    fun provideCharacterRepository(characterRepositoryImpl: CharacterRepositoryImpl): CharacterRepository {
        return characterRepositoryImpl
    }


}