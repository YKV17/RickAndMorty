plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(project(Modules.Common.common_utils))

    implementation(Dependencies.Coroutines.coroutinesCore)
    implementation(Dependencies.JavaDep.javax)

    //Test
    testImplementation(Dependencies.TestDep.junit)
    testImplementation(Dependencies.TestDep.mockitoKotlin)
    testImplementation(Dependencies.Coroutines.coroutinesTest)
    testImplementation(Dependencies.TestDep.jupiter)
}