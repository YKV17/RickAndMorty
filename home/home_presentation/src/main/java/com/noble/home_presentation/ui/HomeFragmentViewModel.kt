package com.noble.home_presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noble.home_domain.use_cases.GetCharacterListUseCase
import com.noble.home_domain.use_cases.GetCharacterListUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val getCharacterListUseCase: GetCharacterListUseCase
) : ViewModel() {

    fun getCharacters(){
        viewModelScope.launch {
            getCharacterListUseCase().collect{

            }
        }
    }

}