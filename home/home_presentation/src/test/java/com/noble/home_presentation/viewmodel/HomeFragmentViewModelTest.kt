package com.noble.home_presentation.viewmodel

import app.cash.turbine.test
import com.nhaarman.mockitokotlin2.verify
import com.noble.common_utils.coroutines.CoroutineContextProvider
import com.noble.common_utils.error.ErrorEntity
import com.noble.common_utils.state.State
import com.noble.common_utils.wrapper.Result
import com.noble.home_domain.models.Character
import com.noble.home_domain.use_cases.GetCharacterListUseCase
import com.noble.home_presentation.ui.HomeFragmentViewModel
import com.noble.home_presentation.util.TestContextProvider

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.lang.Exception

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HomeFragmentViewModelTest {

    @Mock
    private lateinit var getCharacterListUseCase: GetCharacterListUseCase

    private lateinit var contextProvider: CoroutineContextProvider

    private lateinit var sut: HomeFragmentViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        contextProvider = TestContextProvider()
        sut = HomeFragmentViewModel(contextProvider, getCharacterListUseCase)
    }

    @Test
    fun `when initialize sut _ _ then default state is Idle`() {
        assert(sut.characters.value == State.Idle)
    }

    @Test
    fun `given server response 200 _ when fetch _ should return success`() = runTest {
        val expectedResult = Result.Success(listOf<Character>())
        Mockito.`when`(getCharacterListUseCase()).thenReturn(flowOf(expectedResult))

        sut.getCharacters()

        sut.characters.test {

            var state = awaitItem()
            assert(state is State.Success)

            cancelAndIgnoreRemainingEvents()
        }

        verify(getCharacterListUseCase).invoke()
    }

    @Test
    fun `given server response error _ when fetch _ should return error`() = runTest {

        val expectedResult = Result.Error<List<Character>>(ErrorEntity.Unknown)
        Mockito.`when`(getCharacterListUseCase()).thenReturn(flowOf(expectedResult))

        sut.getCharacters()
        sut.characters.test {

            var state = awaitItem()
            assert(state is State.Error)

            cancelAndIgnoreRemainingEvents()
        }

        verify(getCharacterListUseCase).invoke()
    }

    @Test
    fun `exception when giving server response _ when fetch _ should return error`() = runTest {

        val expectedResult = Result.Error<List<Character>>(ErrorEntity.Unknown)
        Mockito.`when`(getCharacterListUseCase()).thenReturn(flow {
            throw Exception("Message")
        })

        sut.getCharacters()
        sut.characters.test {

            var state = awaitItem()
            assert(state is State.Error)

            cancelAndIgnoreRemainingEvents()
        }

        verify(getCharacterListUseCase).invoke()
    }
}