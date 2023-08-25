package com.noble.home_domain.use_cases

import com.noble.common_utils.wrapper.Result
import com.noble.home_domain.models.Character
import com.noble.home_domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCharacterListUseCaseImpl @Inject constructor(
    private val characterRepository: CharacterRepository
) : GetCharacterListUseCase {
    override suspend fun invoke(): Flow<Result<List<Character>>> = flow {
        emit(characterRepository.getCharacters())
    }
}