package com.noble.common_utils.state

import androidx.annotation.StringRes
import com.noble.common_utils.enums.ErrorType

sealed class State<out T>{
    object Idle:State<Nothing>()
    class Loading(@StringRes val messageId: Int):State<Nothing>()
    class Success<out T>(val data: T):State<T>()
    class Error(@StringRes val messageId: Int, val type: ErrorType):State<Nothing>()
}
