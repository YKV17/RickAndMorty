package com.noble.home_data.util

import com.noble.common_utils.coroutines.CoroutineContextProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher

@ExperimentalCoroutinesApi
class TestContextProvider(test: TestDispatcher = UnconfinedTestDispatcher()) : CoroutineContextProvider {

    override val io: CoroutineDispatcher = test

    override val default: CoroutineDispatcher = test

    override val main: CoroutineDispatcher = test
}
