package com.noble.common_utils.extensions

import com.noble.common_utils.R
import com.noble.common_utils.error.ErrorEntity
import com.noble.common_utils.error.Result

fun Result.Error<*>.getErrorString(): Int = when (error) {
    ErrorEntity.AccessDenied -> {
       R.string.access_denied
    }

    ErrorEntity.Network -> {
       R.string.network_issue
    }

    ErrorEntity.NotFound -> {
       R.string.resource_not_found
    }

    ErrorEntity.ServiceUnavailable -> {
       R.string.service_unavailable
    }

    ErrorEntity.Unknown -> {
       R.string.something_went_wrong
    }
}
