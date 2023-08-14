package com.noble.common_utils.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<B: ViewDataBinding>: Fragment() {

    protected lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, getLayout(), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setBinding(view)
        setUpView()
        setObservers()
    }

    override fun onStart() {
        super.onStart()
        setListeners()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
        removeListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        removeObservers()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
    @LayoutRes
    abstract fun getLayout(): Int

    /*abstract fun setBinding(view: View)*/
    abstract fun setUpView()
    abstract fun setListeners()
    abstract fun removeListeners()
    abstract fun setObservers()
    abstract fun removeObservers()
}