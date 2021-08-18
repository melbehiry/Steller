plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android-extensions")
}
group = "com.elbehiry.steller"
version = "1.0-SNAPSHOT"

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
    maven { setUrl("https://dl.bintray.com/ekito/koin") }
}
dependencies {
    api(platform(project(":depconstraints")))
    kapt(platform(project(":depconstraints")))
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.2.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")
    implementation("androidx.core:core-ktx:1.5.0-alpha02")
    // COMPOSE
    implementation(Libs.COMPOSE_RUNTIME)
    implementation(Libs.COMPOSE_UI)
    implementation(Libs.COMPOSE_FOUNDATION_LAYOUT)
    implementation(Libs.COMPOSE_MATERIAL)
    implementation(Libs.COMPOSE_UI_GRAPHICS)
    implementation(Libs.COMPOSE_UI_TOOLING)
    implementation(Libs.COMPOSE_RUNTIME_LIVEDATA)
    implementation(Libs.COMPOSE_ANIMATION)
    implementation(Libs.COMPOSE_NAVIGATION)
    implementation(Libs.COMPOSE_ICON)
    implementation(Libs.COMPOSE_ACTIVITY)
    implementation(Libs.COMPOSE_CONSTRAINT)
    implementation(Libs.COMPOSE_VIEW_MODEL)

    implementation(Libs.INSETS)
    implementation(Libs.COIL)
    implementation(Libs.KOIN_CORE)
    implementation(Libs.KOIN_COMPOSE)
    implementation(Libs.KOIN_ANDROID)

}
android {
    compileSdk = Versions.COMPILE_SDK
    defaultConfig {
        applicationId = "com.elbehiry.steller.app"
        minSdk = Versions.MIN_SDK
        targetSdk = Versions.TARGET_SDK
        versionCode = Versions.versionCodeMobile
        versionName = Versions.versionName
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        compose = true
        buildConfig = false
        aidl = false
        renderScript = false
        resValues = false
        shaders = false
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
        freeCompilerArgs = freeCompilerArgs + "-Xuse-experimental=kotlin.ExperimentalStdlibApi"
        freeCompilerArgs = freeCompilerArgs + "-Xuse-experimental=kotlin.ExperimentalStdlibApi"
        freeCompilerArgs = freeCompilerArgs + "-Xuse-experimental=kotlin.time.ExperimentalTime"
    }
}