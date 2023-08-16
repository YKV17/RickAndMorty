package com.noble.common_utils.adapters.image_loading.options

import android.widget.ImageView
import com.bumptech.glide.Glide

class GlideImageLoadingOptions(private val url: String) : ImageLoadingOptions {

    private var placeholderRes = 0
    private var width = 0
    private var height = 0
    override fun placeholder(placeholderRes: Int): ImageLoadingOptions = apply {
        this.placeholderRes = placeholderRes
    }

    override fun resize(width: Int, height: Int): ImageLoadingOptions = apply {
        this.width = width
        this.height = height
    }

    override fun into(imageView: ImageView) {
        Glide.with(imageView.context)
            .load(url).apply {

                if(placeholderRes != 0){
                    placeholder(placeholderRes)
                }

                if(width > 0 && height > 0){
                    override(width, height)
                }

            }.into(imageView)
    }
}