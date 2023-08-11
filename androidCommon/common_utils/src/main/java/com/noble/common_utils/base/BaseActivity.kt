package com.noble.common_utils.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VM : ViewModel, B : ViewBinding> : AppCompatActivity() {

    private lateinit var binding: B
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayout())
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

    override fun onDestroy() {
        super.onDestroy()
        removeObservers()
    }

    abstract fun setListeners()
    abstract fun removeListeners()
    abstract fun setObservers()
    abstract fun removeObservers()

    @LayoutRes
    abstract fun getLayout(): Int
}