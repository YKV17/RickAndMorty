package com.noble.common_utils.extensions

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

fun <T> LifecycleOwner.observeLatestWhenCreated(stateFlow: StateFlow<T>, block: (T) -> Unit){
    lifecycleScope.launch{
        repeatOnLifecycle(Lifecycle.State.CREATED){
            stateFlow.collectLatest {
                block(it)
            }
        }
    }
}