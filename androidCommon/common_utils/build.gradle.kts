plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.noble.common_utils"
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

    implementation(Dependencies.CoreDep.coreKtx)
    implementation(Dependencies.CoreDep.appCompat)
    implementation(Dependencies.CoreDep.material)
    implementation(Dependencies.CoreDep.constraint)

    testImplementation(Dependencies.TestDep.junit)
    androidTestImplementation(Dependencies.TestDep.testJunitExt)
    androidTestImplementation(Dependencies.TestDep.espressoCore)
}