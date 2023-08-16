package com.noble.common_utils.adapters.image_loading

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.noble.common_utils.adapters.image_loading.options.ImageLoadingOptions
import com.noble.common_utils.adapters.image_loading.options.PicassoImageLoadingOptions

class PicassoImageLoadingAdapter : ImageLoadingAdapter {
    /*override fun loadImage(url: String, imageView: ImageView) {
//        Replace code with picasso
        *//*Picasso.get()
            .load(url)
            .into(imageView)*//*
        Glide.with(imageView.context)
            .load(url)
            .into(imageView)
    }*/

    override fun load(url: String): ImageLoadingOptions {
        return PicassoImageLoadingOptions(url)
    }

}