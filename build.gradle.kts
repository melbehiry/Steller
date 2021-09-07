buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven { setUrl("https://dl.bintray.com/ekito/koin") }
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.ANDROID_GRADLE_PLUGIN}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}")
        classpath("org.jetbrains.kotlin:kotlin-serialization:${Versions.KOTLIN}")
        classpath("org.jetbrains.compose:compose-gradle-plugin:${Versions.COMPOSE_DESKTOP}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}