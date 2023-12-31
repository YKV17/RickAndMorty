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

    object ImageLoadingDep{
        const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
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

        const val coroutinesTest =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTestVersion}"

    }

    object TestDep {
        const val junit = "junit:junit:${Versions.junitVersion}"
        const val testJunitExt = "androidx.test.ext:junit:${Versions.testJunitExtVersion}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
        const val jupiter = "org.junit.jupiter:junit-jupiter:${Versions.jupiterVersion}"

        //    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")

        //Creating mock Objects for testing
        const val mockitoKotlin =
            "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlinVersion}"
        const val mockitoInline = "org.mockito:mockito-inline:${Versions.mockitoInlineVersion}"

        //mockk kotlin
        const val mockk = "io.mockk:mockk:${Versions.mockkVersion}"
        const val mockkAndroid = "io.mockk:mockk-android:${Versions.mockkVersion}"
        const val mockkAgent = "io.mockk:mockk-agent:${Versions.mockkVersion}"



        //Test State Flow
        const val turbine = "app.cash.turbine:turbine:${Versions.turbineVersion}"
    }

    object KotlinDep {
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
    }

}