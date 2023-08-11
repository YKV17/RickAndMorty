plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(Dependencies.CoreDep.coreKtx)
    implementation(Dependencies.CoreDep.appCompat)
    implementation(Dependencies.CoreDep.material)
    implementation(Dependencies.CoreDep.constraint)
    implementation(Dependencies.SplashDep.splash)

    testImplementation(Dependencies.TestDep.junit)
    androidTestImplementation(Dependencies.TestDep.testJunitExt)
    androidTestImplementation(Dependencies.TestDep.espressoCore)
}