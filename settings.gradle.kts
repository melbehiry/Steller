pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
rootProject.name = "Steller"
include(
    ":app",
    ":shared",
    ":depconstraints"
    )