package com.noble.home_domain.repository

import com.noble.common_utils.error.Result
import com.noble.home_domain.models.Character

interface CharacterRepository {
    suspend fun getCharacters(): Result<List<Character>>
    suspend fun getCharacter(id: Long): Character
}