package com.noble.common_utils.state

import com.noble.common_utils.enums.ErrorType

sealed class State<T>{
    class Loading<T>():State<T>()
    class Success<T>(val data: T?):State<T>()
    class Error<T>(val message: String, val type: ErrorType, val data:T? = null):State<T>()
}
