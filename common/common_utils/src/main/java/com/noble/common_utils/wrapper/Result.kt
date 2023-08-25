package com.noble.common_utils.wrapper

import com.noble.common_utils.error.ErrorEntity


sealed class Result<T>{
    data class Success<T>(val data: T): Result<T>()
    data class Error<T>(val error: ErrorEntity): Result<T>()
}
