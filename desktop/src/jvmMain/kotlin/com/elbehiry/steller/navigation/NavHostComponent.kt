package com.elbehiry.steller.navigation

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext

class NavHostComponent(
    private val componentContext: ComponentContext
) : Component, ComponentContext by componentContext {

    @Composable
    override fun render() {

    }
}