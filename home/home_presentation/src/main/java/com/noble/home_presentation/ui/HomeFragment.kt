package com.noble.home_presentation.ui

import android.widget.Toast
import androidx.fragment.app.viewModels
import com.noble.common_utils.base.BaseFragment
import com.noble.common_utils.enums.ErrorType
import com.noble.common_utils.error.ErrorEntity
import com.noble.common_utils.extensions.observeLatestWhenCreated
import com.noble.common_utils.state.State
import com.noble.home_presentation.R
import com.noble.home_presentation.adapter.CharactersAdapter
import com.noble.home_presentation.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeFragmentViewModel, FragmentHomeBinding>() {

    override val viewModel: HomeFragmentViewModel by viewModels()

    @Inject
    lateinit var charactersAdapter: CharactersAdapter

    override fun getViewBinding(): FragmentHomeBinding  = FragmentHomeBinding.inflate(layoutInflater)

    override fun setUpView() {
        viewModel.getCharacters()

        binding.rvCharacters.apply {
            adapter = charactersAdapter
        }
    }

    override fun setListeners() {

    }

    override fun removeListeners() {

    }

    override fun setObservers() {

        observeLatestWhenCreated(viewModel.characters) {state ->
            when (state) {
                State.Idle -> {

                }
                is State.Loading -> {

                }
                is State.Success -> {
                    charactersAdapter.list = state.data
                }
                is State.Error -> {
                    handleError(state)
                    
                }
                else -> {}
            }
        }
    }

    private fun handleError(error: State.Error){

        when(error.type){
            ErrorType.NO_INTERNET -> {
                Toast.makeText(requireContext(), getString(R.string.no_internet_connection), Toast.LENGTH_SHORT).show()
            }
            ErrorType.CUSTOM_ERROR -> {
                when(error.error){
                    ErrorEntity.AccessDenied -> {}
                    ErrorEntity.Network -> {}
                    ErrorEntity.NotFound -> {}
                    ErrorEntity.ServiceUnavailable -> {}
                    ErrorEntity.Unknown -> {

                    }
                }
            }

            ErrorType.EMPTY -> {

            }
        }
    }

    override fun removeObservers() {

    }

}