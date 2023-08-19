package com.noble.home_domain.use_cases

import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.noble.home_domain.repository.CharacterRepository
import com.noble.home_domain.util.FakeData
import com.noble.home_domain.util.MainDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.assertThrows
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.net.http.HttpTimeoutException

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class GetCharacterListUseCaseImplTest {

    @Mock
    private lateinit var characterRepository: CharacterRepository

    private lateinit var sut: GetCharacterListUseCaseImpl

    @get:Rule
    val coroutineDispatcherRule = MainDispatcherRule()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        sut = GetCharacterListUseCaseImpl(characterRepository)
    }

    @Test
    fun `when return success the repository method should return flow of list and should be called max 1 time`() =
        runTest {

            Mockito.`when`(characterRepository.getCharacters()).thenReturn(FakeData.getCharacters())

            val characters = sut.invoke().single()

            assert(characters.size == 2)
            verify(characterRepository, times(1)).getCharacters()

        }

    @Test
    fun `when return error the repository method return with exception 1`() = runTest {

        Mockito.`when`(characterRepository.getCharacters()).doAnswer { throw HttpTimeoutException("Thrown from repository")}

        val exception = assertThrows<HttpTimeoutException> {
                sut.invoke().single()
        }

        assert(exception.message == "Thrown from repository")
        verify(characterRepository, times(1)).getCharacters()
    }


}