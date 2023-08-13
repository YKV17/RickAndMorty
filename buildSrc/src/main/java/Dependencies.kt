object Dependencies {
    object CoreDep {
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
        const val material = "com.google.android.material:material:${Versions.materialVersion}"
        const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraintVersion}"
    }

    object Fragment{
        const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtxVersion}"
    }

    object SplashDep{
        const val splash = "androidx.core:core-splashscreen:${Versions.splashVersion}"
    }

    object MultiDex{
        const val multidex = "androidx.multidex:multidex:${Versions.multidexVersion}"
    }

    object HiltDep{
        const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val hiltCore = "com.google.dagger:hilt-core:${Versions.hilt}"
        const val hiltAndroidCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
        const val hiltAndroidTest = "com.google.dagger:hilt-android-testing:${Versions.hilt}"
    }

    object JavaDep {
        const val javax = "javax.inject:javax.inject:${Versions.javaxInjectVersion}"
    }

    object Retrofit{
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
        const val retrofitOkHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    }

    object Coroutines{
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    }

    object TestDep {
        const val junit = "junit:junit:${Versions.junitVersion}"
        const val testJunitExt = "androidx.test.ext:junit:${Versions.testJunitExtVersion}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
    }

}