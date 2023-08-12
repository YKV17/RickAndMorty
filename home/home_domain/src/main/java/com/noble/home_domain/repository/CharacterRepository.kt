package com.noble.home_domain.repository

import com.noble.home_domain.models.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
    suspend fun getCharacter(id: Long): Character
}