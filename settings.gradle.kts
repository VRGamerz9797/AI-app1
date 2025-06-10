// Include the app module
include(":app")pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {
        id("com.android.application") version "8.2.2"
        id("org.jetbrains.kotlin.android") version "1.9.0"
    }
}

rootProject.name = "AI-app1"
include(":app")

// End of file