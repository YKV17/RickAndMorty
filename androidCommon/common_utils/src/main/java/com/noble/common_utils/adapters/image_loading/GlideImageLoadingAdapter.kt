package com.noble.common_utils.adapters.image_loading

import android.widget.ImageView
import com.bumptech.glide.Glide

class GlideImageLoadingAdapter: ImageLoadingAdapter {

    override fun loadImage(url: String, imageView: ImageView) {
        Glide.with(imageView.context)
            .load(url)
            .into(imageView)
    }
}