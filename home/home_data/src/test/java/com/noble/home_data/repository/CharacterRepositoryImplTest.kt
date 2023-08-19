package com.noble.home_data.repository

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.noble.home_data.mapper.toDomainModel
import com.noble.home_data.network.CharacterService
import com.noble.home_data.util.FakeData
import com.noble.home_domain.models.Character
import com.noble.home_domain.use_cases.GetCharacterListUseCaseImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.assertThrows
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.net.http.HttpTimeoutException

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class CharacterRepositoryImplTest {

    @Mock
    private lateinit var characterService: CharacterService

    private lateinit var sut: CharacterRepositoryImpl

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        sut = CharacterRepositoryImpl(characterService)
    }

    @Test
    fun `when return success the repository method should return list of character and characterService getCharacters should be called max 1 time`() = runTest {

        val fakeData = FakeData.getCharacterResponseDtoWithData()
        Mockito.`when`(characterService.getCharacters()).thenReturn(fakeData)

        val response = sut.getCharacters()

        assert(response.size == 1)
        assert(response[0] is Character)
        assert(response[0].name == "Flansian")
        assert(response[0].id == 125L)
        verify(characterService, times(1)).getCharacters()
    }

    @Test
    fun `when return success the repository method should return empty list of character and characterService getCharacters should be called max 1 time`() = runTest {

        val fakeData = FakeData.getCharacterResponseDtoEmpty()
        Mockito.`when`(characterService.getCharacters()).thenReturn(fakeData)

        val response = sut.getCharacters()

        assert(response.isEmpty())
        verify(characterService, times(1)).getCharacters()
    }

    @Test
    fun `when return error the repository method should return exception and characterService getCharacters should be called max 1 time`() = runTest {
        Mockito.`when`(characterService.getCharacters()).doAnswer { throw HttpTimeoutException("Exception from service") }

        val exception = assertThrows<HttpTimeoutException> {
            sut.getCharacters()
        }

        assert(exception.message == "Exception from service")
        verify(characterService, times(1)).getCharacters()
    }




    @Test
    fun `when return success the repository method should return the character Details and characterService getCharacter should be called max 1 time`() = runTest {

        val fakeData = FakeData.getResult()
        Mockito.`when`(characterService.getCharacter(ArgumentMatchers.anyLong())).thenReturn(fakeData)

        val response = sut.getCharacter(1)

        assert(response.name == "Flansian")
        assert(response.id == 125L)
        verify(characterService, times(1)).getCharacter(1)
    }

    @Test
    fun `when return error the repository method should return exception and characterService getCharacter should be called max 1 time`() = runTest {
        Mockito.`when`(characterService.getCharacter(ArgumentMatchers.anyLong())).doAnswer { throw HttpTimeoutException("Exception from service") }

        val exception = assertThrows<HttpTimeoutException> {
            sut.getCharacter(1)
        }

        assert(exception.message == "Exception from service")
        verify(characterService, times(1)).getCharacter(1)
    }
}