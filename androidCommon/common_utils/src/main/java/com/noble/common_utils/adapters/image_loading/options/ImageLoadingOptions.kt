package com.noble.common_utils.adapters.image_loading.options

import android.widget.ImageView

interface ImageLoadingOptions {
    fun placeholder(placeholderRes: Int): ImageLoadingOptions
    fun resize(width: Int, height: Int): ImageLoadingOptions
    fun into(imageView: ImageView)
}