package com.noble.home_presentation.ui

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.noble.common_utils.base.BaseFragment
import com.noble.home_presentation.R
import com.noble.home_presentation.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeFragmentViewModel, FragmentHomeBinding>() {

    override val viewModel: HomeFragmentViewModel by viewModels()
    override fun getLayout(): Int = R.layout.fragment_home

    override fun setUpView() {
        viewModel.getCharacters()
    }

    override fun setListeners() {

    }

    override fun removeListeners() {

    }

    override fun setObservers() {

    }

    override fun removeObservers() {

    }

}