package com.noble.home_presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noble.common_utils.enums.ErrorType
import com.noble.common_utils.state.State
import com.noble.home_domain.models.Character
import com.noble.home_domain.use_cases.GetCharacterListUseCase
import com.noble.home_presentation.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val getCharacterListUseCase: GetCharacterListUseCase
) : ViewModel() {

    private val _characters: MutableStateFlow<State<List<Character>>> by lazy {
        MutableStateFlow(State.Idle)
    }
    val characters: StateFlow<State<List<Character>>>
        get() = _characters

    fun getCharacters() {
        viewModelScope.launch {
            try {
                _characters.value = State.Loading(R.string.loading)
                getCharacterListUseCase().collect { data ->
                    if(data != null) {
                        _characters.value = State.Success<List<Character>>(data)
                    }else{
                        _characters.value = State.Error(R.string.something_went_wrong, ErrorType.EMPTY)
                    }
                }
            } catch (e: Exception) {
                _characters.value = State.Error(R.string.something_went_wrong, ErrorType.CUSTOM_ERROR)
            }
        }
    }

}