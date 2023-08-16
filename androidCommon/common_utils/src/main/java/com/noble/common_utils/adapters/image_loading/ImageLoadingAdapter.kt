package com.noble.common_utils.adapters.image_loading

import android.widget.ImageView
import com.noble.common_utils.adapters.image_loading.options.ImageLoadingOptions


interface ImageLoadingAdapter {
    /*fun loadImage(url: String, imageView: ImageView)*/
    fun load(url: String): ImageLoadingOptions
}