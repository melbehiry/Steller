pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        jcenter()
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "com.android" || requested.id.name == "kotlin-android-extensions") {
                useModule("com.android.tools.build:gradle:4.2.0-alpha12")
            }
        }
    }
}
rootProject.name = "Steller"


include(":app",":shared")
enableFeaturePreview("GRADLE_METADATA")

