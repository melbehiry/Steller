package com.elbehiry.steller.navigation

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.animation.child.crossfadeScale
import com.arkivanov.decompose.router
import com.elbehiry.steller.ui.feature.photo.PhotoScreenComponent
import com.elbehiry.steller.ui.feature.splash.SplashScreenComponent

@ExperimentalDecomposeApi
class NavHostComponent(
    private val componentContext: ComponentContext
) : Component, ComponentContext by componentContext {

    init {
        initDesktopKoin()
    }

    private val router = router<Config, Component>(
        initialConfiguration = Config.PhotoList,
        childFactory = ::createScreenComponent
    )

    @Composable
    override fun render() {
        Children(
            routerState = router.state,
            animation = crossfadeScale()
        ) { child ->
            child.instance.render()
        }
    }

    /**
     * When a new navigation request made, the screen will be created by this method.
     */
    private fun createScreenComponent(
        config: Config,
        componentContext: ComponentContext
    ): Component {
        return when (config) {
            is Config.Splash -> SplashScreenComponent(
                componentContext = componentContext
            )
            is Config.PhotoList -> PhotoScreenComponent(
                componentContext = componentContext
            )
        }
    }

    private fun initDesktopKoin() {
//      initKoin {
//          modules(desktopModule)
//      }
    }
}