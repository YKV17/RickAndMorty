plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(project(Modules.Home.home_domain))
    implementation(project(Modules.Common.common_utils))

    implementation(Dependencies.JavaDep.javax)
    implementation(Dependencies.Retrofit.retrofit)

    //Test
    testImplementation(Dependencies.TestDep.junit)
    testImplementation(Dependencies.TestDep.mockitoKotlin)
    testImplementation(Dependencies.Coroutines.coroutinesTest)
    testImplementation(Dependencies.TestDep.jupiter)
}