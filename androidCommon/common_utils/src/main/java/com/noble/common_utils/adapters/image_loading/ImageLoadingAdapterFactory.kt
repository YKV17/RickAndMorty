package com.noble.common_utils.adapters.image_loading

import com.noble.common_utils.enums.ImageLoadingLibraryType

class ImageLoadingAdapterFactory {
    companion object{
        fun getImageLoadingAdapterFromType(type: ImageLoadingLibraryType): ImageLoadingAdapter{
            return when(type){
                ImageLoadingLibraryType.GLIDE -> {
                    GlideImageLoadingAdapter()
                }
                ImageLoadingLibraryType.PICASSO -> {
                    PicassoImageLoadingAdapter()
                }
            }
        }
    }
}