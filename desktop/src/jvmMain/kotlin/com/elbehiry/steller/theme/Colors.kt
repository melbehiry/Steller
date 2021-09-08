package com.elbehiry.steller.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver

val purple200 = Color(0xFF651FFF)
val purple500 = Color(0xFF6200EA)
val background = Color(0xFF2B292B)
val background800 = Color(0xFF424242)
val background900 = Color(0xFF212121)
val white87 = Color(0Xddffffff)

val darkPrimary = Color(0xff242316)

val blue200 = Color(0xff91a4fc)
val Green500 = Color(0xFF1EB980)
val DarkBlue900 = Color(0xFF26282F)
val orangeError = Color(0xFFF94701)

/**
 * Return the fully opaque color that results from compositing [onSurface] atop [surface] with the
 * given [alpha]. Useful for situations where semi-transparent colors are undesirable.
 */
@Composable
fun Colors.compositedOnSurface(alpha: Float): Color {
    return onSurface.copy(alpha = alpha).compositeOver(surface)
}