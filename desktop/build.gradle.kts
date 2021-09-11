import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "com.elbehiry.steller"
version = "1.0-SNAPSHOT"

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    sourceSets {
        val jvmMain by getting {
            dependencies {
                api(project(":depconstraints"))
                implementation(project(":shared"))
                implementation(compose.desktop.currentOs)
                implementation(compose.runtime)
                implementation(compose.material)
                implementation(compose.preview)
                implementation(compose.foundation)
                implementation(compose.materialIconsExtended)
                implementation(compose.animation)
                implementation(Libs.KAMEL_IMAGE)
                implementation(Libs.DECOMPOSE_EXT)
                implementation(Libs.DECOMPOSE_JVM)
                // koin
                implementation(Libs.KOIN_CORE)
            }
        }
        val jvmTest by getting
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "jvm"
            packageVersion = "1.0.0"
        }
    }
}