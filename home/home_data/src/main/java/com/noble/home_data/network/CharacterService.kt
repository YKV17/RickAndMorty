package com.noble.home_data.network

import com.noble.home_data.dto.CharactersResponseDto
import com.noble.home_data.dto.Result
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {

    @GET("character")
    suspend fun getCharacters(): CharactersResponseDto

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Long): Result
}