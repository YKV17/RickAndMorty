plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {

    implementation(Dependencies.Coroutines.coroutinesCore)

    implementation(Dependencies.JavaDep.javax)
}