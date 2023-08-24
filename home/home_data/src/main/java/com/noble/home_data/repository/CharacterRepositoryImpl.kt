package com.noble.home_data.repository

import com.noble.common_utils.error.ErrorEntity
import com.noble.common_utils.error.Result
import com.noble.common_utils.extensions.getError
import com.noble.home_data.mapper.toDomainModel
import com.noble.home_data.network.CharacterService
import com.noble.home_domain.models.Character
import com.noble.home_domain.repository.CharacterRepository
import retrofit2.HttpException
import java.io.IOException
import java.net.HttpURLConnection
import java.net.UnknownHostException
import java.net.http.HttpTimeoutException
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val characterService: CharacterService
) : CharacterRepository {

    override suspend fun getCharacters(): Result<List<Character>> {
        runCatching {
            characterService.getCharacters()
        }.onSuccess { response ->
            return Result.Success(response.results?.map { result ->
                result.toDomainModel()
            } ?: Character.getCharacterList())
        }.onFailure { exception ->
            return Result.Error(exception.getError())
        }
        return Result.Error(ErrorEntity.Unknown)
    }

    override suspend fun getCharacter(id: Long): Character {
        return characterService.getCharacter(id).toDomainModel()
    }
}