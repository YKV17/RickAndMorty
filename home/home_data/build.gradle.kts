plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(project(Modules.Home.home_domain))

    implementation(Dependencies.Coroutines.coroutinesCore)

    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.retrofitOkHttp)
    implementation(Dependencies.Retrofit.retrofitGsonConverter)
}