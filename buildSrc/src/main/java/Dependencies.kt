
object Versions {
    const val kotlin = "1.5.10"
    const val kotlinCoroutines = "1.5.1"
    const val ktor = "1.4.0"
    const val kotlinxSerialization = "1.0.0-RC"
    const val koin = "3.1.2"
    const val gradleVersion = "7.0.0"
    const val androidXcore = "1.5.0-alpha02"
    const val lifecycle = "2.2.0-alpha01"
    const val compose = "1.0.0"
    const val composeNavigation = "2.4.0-alpha05"
    const val composeActivity = "1.3.0"
    const val composeConstraint = "1.0.0-beta01"
    const val composePaging = "1.0.0-alpha11"
    const val composeViewModel = "1.0.0-alpha07"
    const val accompanist = "0.15.0"

    const val junit = "4.13"
    const val testRunner = "1.3.0"
}


object AndroidSdk {
    const val min = 21
    const val compile = 30
    const val target = compile
}

object Compose {
    const val COMPOSE_UI = "androidx.compose.ui:ui:${Versions.compose}"
    const val COMPOSE_UI_GRAPHICS = "androidx.compose.ui:ui-graphics:${Versions.compose}"
    const val COMPOSE_UI_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val COMPOSE_FOUNDATION_LAYOUT = "androidx.compose.foundation:foundation-layout:${Versions.compose}"
    const val COMPOSE_MATERIAL = "androidx.compose.material:material:${Versions.compose}"
    const val COMPOSE_RUNTIME_LIVEDATA = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
    const val COMPOSE_RUNTIME = "androidx.compose.runtime:runtime:${Versions.compose}"
    const val COMPOSE_ANIMATION = "androidx.compose.animation:animation:${Versions.compose}"
    const val COMPOSE_ANIMATION_CORE = "androidx.compose.animation:animation-core:${Versions.compose}"
    const val COMPOSE_NAVIGATION = "androidx.navigation:navigation-compose:${Versions.composeNavigation}"
    const val COMPOSE_ACTIVITY = "androidx.activity:activity-compose:${Versions.composeActivity}"
    const val COMPOSE_CONSTRAINT = "androidx.constraintlayout:constraintlayout-compose:${Versions.composeConstraint}"
    const val COMPOSE_ICON = "androidx.compose.material:material-icons-extended:${Versions.compose}"
    const val COMPOSE_TEST = "androidx.compose.ui:ui-test-junit4:1.0.0-rc01:${Versions.compose}"
    const val COMPOSE_PAGING = "androidx.paging:paging-compose:${Versions.composePaging}"
    const val COMPOSE_VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.composeViewModel}"
    const val INSETS = "com.google.accompanist:accompanist-insets:${Versions.accompanist}"
    const val COIL = "com.google.accompanist:accompanist-coil:${Versions.accompanist}"
}

object Koin {
    val core = "io.insert-koin:koin-core:${Versions.koin}"
    val android = "io.insert-koin:koin-android:${Versions.koin}"
    val jetpackCompose = "io.insert-koin:koin-androidx-compose:${Versions.koin}"
    val Ktor = "io.insert-koin:koin-ktor:${Versions.koin}"
    val Logger = "io.insert-koin:koin-logger-slf4j:${Versions.koin}"
}


