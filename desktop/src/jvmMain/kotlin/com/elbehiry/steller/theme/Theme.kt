package com.elbehiry.steller.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Green500,
    secondary = Green500,
    onSecondary = Color.Black,
    surface = darkPrimary,
    background = background,
    onBackground = background800,
    primaryVariant = purple500,
    onPrimary = Color.Black,
    onSurface = Color.White
)

private val LightColorPalette = lightColors(
    primary = Green500,
    secondary = Green500,
    onSecondary = Color.Black,
    surface = darkPrimary,
    background = background,
    onBackground = background800,
    primaryVariant = purple500,
    onPrimary = Color.Black,
    onSurface = Color.White
)

@Composable
fun StellerTheme(
    isDark: Boolean = true,
    content: @Composable (ColumnScope) -> Unit
) {
    MaterialTheme(
        colors = if (isDark) DarkColorPalette else LightColorPalette,
        typography = if (isDark) DarkTypography else LightTypography
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column {
                content(this)
            }
        }
    }
}