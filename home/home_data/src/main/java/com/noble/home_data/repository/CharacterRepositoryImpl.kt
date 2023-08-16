package com.noble.home_data.repository

import com.noble.home_data.mapper.toDomainModel
import com.noble.home_data.network.CharacterService
import com.noble.home_domain.models.Character
import com.noble.home_domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val characterService: CharacterService
) : CharacterRepository {

    override suspend fun getCharacters(): List<Character> {
        return characterService.getCharacters().results?.map { result ->
            result.toDomainModel()
        } ?: Character.getCharacterList()

    }

    override suspend fun getCharacter(id: Long): Character {
        return characterService.getCharacter(id).toDomainModel()
    }
}