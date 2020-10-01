buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
        classpath("com.android.tools.build:gradle:${Versions.gradleVersion}")
    }
}
group = "com.elbehiry.steller"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
