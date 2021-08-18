import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("kotlin-android-extensions")
    id("kotlinx-serialization")
}
version = "1.0.0"

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
    maven { setUrl("https://dl.bintray.com/ekito/koin") }
}
kotlin {
    android()

    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget = when {
        System.getenv("SDK_NAME")?.startsWith("iphoneos") == true -> ::iosArm64
        else -> ::iosX64
    }

    iosTarget("ios") {}

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        frameworkName = "shared"
        podfile = project.file("../iosApp/Podfile")
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":depconstraints"))
                // Coroutines
                implementation(Libs.COROUTINES)
                // Ktor
                implementation(Libs.KTOR_CORE)
                implementation(Libs.KTOR_JSON)
                implementation(Libs.KTOR_LOGGING)
                implementation(Libs.KTOR_SERIALIZATION)
                // Serialize
                implementation(Libs.KOTLIN_SERIALIZATION)
                // koin
                implementation(Libs.KOIN_CORE)
            }
        }
        val androidMain by getting {
            dependencies {
                api(project(":depconstraints"))
                implementation(Libs.KTOR_ANDROID)
            }
        }
        val androidTest by getting {
            dependencies {}
        }
        val iosMain by getting
        val iosTest by getting
    }
}
android {
    compileSdk = Versions.COMPILE_SDK
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = Versions.MIN_SDK
        targetSdk = Versions.TARGET_SDK
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}