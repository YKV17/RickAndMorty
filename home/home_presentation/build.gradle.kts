plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.noble.home_presentation"
    compileSdk = 33

    defaultConfig {
        minSdk = 23

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    implementation(project(Modules.AndroidCommon.common_utils))
    implementation(project(Modules.Common.common_utils))
    implementation(project(Modules.Home.home_domain))

    implementation(Dependencies.CoreDep.coreKtx)
    implementation(Dependencies.CoreDep.appCompat)
    implementation(Dependencies.CoreDep.material)
    implementation(Dependencies.CoreDep.constraint)
    implementation(Dependencies.Fragment.fragmentKtx)

    //Splash Screen API
    implementation(Dependencies.SplashDep.splash)

    //Hilt
    implementation(Dependencies.HiltDep.hiltAndroid)
    kapt(Dependencies.HiltDep.hiltAndroidCompiler)

    //Test
    testImplementation(Dependencies.TestDep.junit)

    testImplementation(Dependencies.TestDep.mockitoKotlin)
    testImplementation(Dependencies.TestDep.mockitoKotlin)
    testImplementation(Dependencies.Coroutines.coroutinesTest)
    testImplementation(Dependencies.TestDep.turbine)
    testImplementation(Dependencies.Coroutines.coroutinesCore)
    androidTestImplementation(Dependencies.TestDep.testJunitExt)
    androidTestImplementation(Dependencies.TestDep.espressoCore)
}