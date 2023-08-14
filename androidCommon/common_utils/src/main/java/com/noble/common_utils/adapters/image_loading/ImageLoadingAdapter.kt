package com.noble.common_utils.adapters.image_loading

import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView

interface ImageLoadingAdapter {
    fun loadImage(url: String, imageView: ImageView)
}