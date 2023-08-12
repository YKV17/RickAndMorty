package com.noble.home_domain.use_cases

import com.noble.home_domain.models.Character
import kotlinx.coroutines.flow.Flow

interface GetCharacterListUseCase {
    suspend operator fun invoke(): Flow<List<Character>>
}