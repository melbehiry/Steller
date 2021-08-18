plugins {
    id("java-platform")
    id("maven-publish")
}

val kotlinCoroutines = "1.5.1"
val ktor = "1.4.0"
val kotlinxSerialization = "1.0.0-RC"
val koin = "3.1.2"
val androidXcore = "1.5.0-alpha02"
val compose = "1.0.0"
val composeNavigation = "2.4.0-alpha05"
val composeActivity = "1.3.0"
val composeConstraint = "1.0.0-beta01"
val composePaging = "1.0.0-alpha11"
val composeViewModel = "1.0.0-alpha07"
val accompanist = "0.15.0"
val junit = "4.13"
val testRunner = "1.3.0"
val appCompat = "1.2.0-rc01"
val core = "1.6.0"
val lifecycle = "2.3.1"
val lifecycleExt = "2.2.0"
val coroutines = "1.5.1"

dependencies{
    constraints {
        api("${Libs.CORE_KTX}:$core")
        api("${Libs.APP_COMPAT}:$appCompat")
        api("${Libs.LIFECYCLE_EXTENSION}:$lifecycleExt")
        api("${Libs.LIFECYCLE_RUN_TIME}:$lifecycle")
        api("${Libs.COMPOSE_UI}:$compose")
        api("${Libs.COMPOSE_UI_GRAPHICS}:$compose")
        api("${Libs.COMPOSE_UI_TOOLING}:$compose")
        api("${Libs.COMPOSE_FOUNDATION_LAYOUT}:$compose")
        api("${Libs.COMPOSE_MATERIAL}:$compose")
        api("${Libs.COMPOSE_RUNTIME_LIVEDATA}:$compose")
        api("${Libs.COMPOSE_RUNTIME}:$compose")
        api("${Libs.COMPOSE_ANIMATION}:$compose")
        api("${Libs.COMPOSE_ANIMATION}:$compose")
        api("${Libs.COMPOSE_ANIMATION_CORE}:$compose")
        api("${Libs.COMPOSE_ICON}:$compose")
        api("${Libs.COMPOSE_TEST}:$compose")
        api("${Libs.COMPOSE_NAVIGATION}:$composeNavigation")
        api("${Libs.COMPOSE_ACTIVITY}:$composeActivity")
        api("${Libs.COMPOSE_CONSTRAINT}:$composeConstraint")
        api("${Libs.INSETS}:$accompanist")
        api("${Libs.COIL}:$accompanist")
        api("${Libs.KOIN_CORE}:$koin")
        api("${Libs.KOIN_ANDROID}:$koin")
        api("${Libs.KOIN_COMPOSE}:$koin")
        api("${Libs.KOIN_KTOR}:$koin")
        api("${Libs.KOIN_LOGGER}:$koin")
        api("${Libs.COROUTINES}:$coroutines")
        api("${Libs.KTOR_CORE}:$ktor")
        api("${Libs.KTOR_JSON}:$ktor")
        api("${Libs.KTOR_LOGGING}:$ktor")
        api("${Libs.KTOR_SERIALIZATION}:$ktor")
        api("${Libs.KTOR_ANDROID}:$ktor")
        api("${Libs.KOTLIN_SERIALIZATION}:$kotlinxSerialization")
    }
}