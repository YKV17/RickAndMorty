package com.noble.common_utils.coroutines

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutineContextProvider {
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
    val main: CoroutineDispatcher
}