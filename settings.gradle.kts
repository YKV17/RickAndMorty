pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "RickAndMorty"
include(":app")

include(":androidCommon:common_utils")
include(":common:common_utils")

include(":home:home_data")
include(":home:home_domain")
include(":home:home_presentation")
