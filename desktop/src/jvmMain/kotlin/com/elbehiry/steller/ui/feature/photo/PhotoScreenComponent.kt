package com.elbehiry.steller.ui.feature.photo

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.ComponentContext
import com.elbehiry.steller.navigation.Component

class PhotoScreenComponent(
    private val componentContext: ComponentContext
) : Component, ComponentContext by componentContext {

    @Composable
    override fun render() {
        Spacer(
            modifier = Modifier.height(420.dp)
        )
    }
}