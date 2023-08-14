package com.noble.rickandmorty.di

import com.noble.common_utils.adapters.image_loading.ImageLoadingAdapter
import com.noble.common_utils.adapters.image_loading.ImageLoadingAdapterFactory
import com.noble.common_utils.enums.ImageLoadingLibraryType
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {
    @Provides
    fun provideImageLoaderAdapter(): ImageLoadingAdapter{
        return ImageLoadingAdapterFactory.getImageLoadingAdapterFromType(ImageLoadingLibraryType.GLIDE)
    }
}