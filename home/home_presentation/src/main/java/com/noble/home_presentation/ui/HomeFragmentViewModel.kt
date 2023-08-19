package com.noble.home_presentation.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noble.common_utils.coroutines.CoroutineContextProvider
import com.noble.common_utils.enums.ErrorType
import com.noble.common_utils.state.State
import com.noble.home_domain.models.Character
import com.noble.home_domain.use_cases.GetCharacterListUseCase
import com.noble.home_presentation.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val contextProvider: CoroutineContextProvider,
    private val getCharacterListUseCase: GetCharacterListUseCase
) : ViewModel() {

    private val _characters: MutableStateFlow<State<List<Character>>> by lazy {
        MutableStateFlow(State.Idle)
    }
    val characters: StateFlow<State<List<Character>>>
        get() = _characters

    fun getCharacters() {
        viewModelScope.launch(contextProvider.io) {
            try {
                _characters.value = State.Loading(R.string.loading)
                getCharacterListUseCase()
                    .collect { data ->

                        _characters.value = State.Success<List<Character>>(data)

                }
            } catch (e: Exception) {
                _characters.value = State.Error(R.string.something_went_wrong, ErrorType.CUSTOM_ERROR)
            }
        }
    }

}