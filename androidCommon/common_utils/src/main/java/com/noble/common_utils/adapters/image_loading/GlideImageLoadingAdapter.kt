package com.noble.common_utils.adapters.image_loading

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.noble.common_utils.adapters.image_loading.options.GlideImageLoadingOptions
import com.noble.common_utils.adapters.image_loading.options.ImageLoadingOptions

class GlideImageLoadingAdapter: ImageLoadingAdapter {

    /*override fun loadImage(url: String, imageView: ImageView) {
        Glide.with(imageView.context)
            .load(url)
            .into(imageView)
    }*/

    override fun load(url: String): ImageLoadingOptions {
        return GlideImageLoadingOptions(url)
    }
}