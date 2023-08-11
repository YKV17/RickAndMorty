object Dependencies {
    object CoreDep {
        val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
        val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
        val material = "com.google.android.material:material:${Versions.materialVersion}"
        val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraintVersion}"
    }

    object SplashDep{
        val splash = "androidx.core:core-splashscreen:${Versions.splashVersion}"
    }

    object TestDep {
        var junit = "junit:junit:${Versions.junitVersion}"
        var testJunitExt = "androidx.test.ext:junit:${Versions.testJunitExtVersion}"
        var espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
    }
}