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

rootProject.name = "MultiModuleApp"
include(":app")
include(":feature:category:ui")
include(":feature:categoryDetails:ui")
include(":core:common")
include(":feature:category:data")
include(":feature:category:domain")
