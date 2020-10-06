package com.elbehiry.steller.app.ui.ext

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawOpacity

fun Modifier.visible(visibility: Boolean): Modifier {
    return if (visibility) {
        this.then(drawOpacity(1f))
    } else {
        this.then(drawOpacity(0f))
    }
}