plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.noble.rickandmorty"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.noble.rickandmorty"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(project(Modules.Common.common_utils))
    implementation(project(Modules.Home.home_data))
    implementation(project(Modules.Home.home_domain))
    implementation(project(Modules.Home.home_presentation))

    implementation(Dependencies.CoreDep.coreKtx)
    implementation(Dependencies.CoreDep.appCompat)
    implementation(Dependencies.CoreDep.material)
    implementation(Dependencies.CoreDep.constraint)
    implementation(Dependencies.SplashDep.splash)
    implementation(Dependencies.HiltDep.hiltAndroid)
    kapt(Dependencies.HiltDep.hiltAndroidCompiler)

    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.retrofitOkHttp)
    implementation(Dependencies.Retrofit.retrofitGsonConverter)

    testImplementation(Dependencies.TestDep.junit)
    androidTestImplementation(Dependencies.TestDep.testJunitExt)
    androidTestImplementation(Dependencies.TestDep.espressoCore)
}