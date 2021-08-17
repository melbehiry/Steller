plugins {
    id("com.android.application")
    kotlin("android")
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
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.2.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")
    implementation("androidx.core:core-ktx:${Versions.androidXcore}")
    // COMPOSE
    implementation(Compose.COMPOSE_RUNTIME)
    implementation(Compose.COMPOSE_UI)
    implementation(Compose.COMPOSE_FOUNDATION_LAYOUT)
    implementation(Compose.COMPOSE_MATERIAL)
    implementation(Compose.COMPOSE_UI_GRAPHICS)
    implementation(Compose.COMPOSE_UI_TOOLING)
    implementation(Compose.COMPOSE_RUNTIME_LIVEDATA)
    implementation(Compose.COMPOSE_ANIMATION)
    implementation(Compose.COMPOSE_NAVIGATION)
    implementation(Compose.COMPOSE_ICON)
    implementation(Compose.COMPOSE_ACTIVITY)
    implementation(Compose.COMPOSE_CONSTRAINT)
    implementation(Compose.COMPOSE_PAGING)
    implementation(Compose.COMPOSE_VIEW_MODEL)

    implementation(Compose.INSETS)
    implementation(Compose.COIL)
    implementation(Koin.core)
    implementation(Koin.jetpackCompose)
    implementation(Koin.android)

}
android {
    compileSdk = AndroidSdk.compile
    defaultConfig {
        applicationId = "com.elbehiry.steller.app"
        minSdk = AndroidSdk.min
        targetSdk = AndroidSdk.target
        versionCode = 1
        versionName = "1.0"
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
        kotlinCompilerExtensionVersion = Versions.compose
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
        freeCompilerArgs = freeCompilerArgs + "-Xuse-experimental=kotlin.ExperimentalStdlibApi"
        freeCompilerArgs = freeCompilerArgs + "-Xuse-experimental=kotlin.ExperimentalStdlibApi"
        freeCompilerArgs = freeCompilerArgs + "-Xuse-experimental=kotlin.time.ExperimentalTime"
    }
}