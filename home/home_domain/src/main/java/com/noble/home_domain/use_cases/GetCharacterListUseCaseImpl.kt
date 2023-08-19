package com.noble.home_domain.use_cases

import com.noble.home_domain.models.Character
import com.noble.home_domain.repository.CharacterRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCharacterListUseCaseImpl @Inject constructor(
    private val characterRepository: CharacterRepository
) : GetCharacterListUseCase {
    override suspend fun invoke(): Flow<List<Character>> = flow {
        emit(characterRepository.getCharacters())
    }
}