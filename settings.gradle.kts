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
    ":desktop",
    ":shared",
    ":depconstraints"
    )