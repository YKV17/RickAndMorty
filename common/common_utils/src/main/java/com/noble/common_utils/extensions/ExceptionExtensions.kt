package com.noble.common_utils.extensions

import com.noble.common_utils.error.ErrorEntity
import retrofit2.HttpException
import java.io.IOException
import java.net.HttpURLConnection

fun Throwable.getError(): ErrorEntity{
    return when(this) {
        is IOException -> ErrorEntity.Network
        is HttpException -> {
            when(code()) {

                // not found
                HttpURLConnection.HTTP_NOT_FOUND -> ErrorEntity.NotFound

                // access denied
                HttpURLConnection.HTTP_FORBIDDEN -> ErrorEntity.AccessDenied

                // unavailable service
                HttpURLConnection.HTTP_UNAVAILABLE -> ErrorEntity.ServiceUnavailable

                // all the others will be treated as unknown error
                else -> ErrorEntity.Unknown
            }
        }
        else -> ErrorEntity.Unknown
    }
}