package com.elbehiry.steller.app.ui

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import com.elbehiry.steller.app.ui.util.Navigator
import kotlinx.android.parcel.Parcelize

/**
 * Models the screens in the app and any arguments they require.
 */
sealed class Destination : Parcelable {
    @Parcelize
    object Home : Destination()

    @Immutable
    @Parcelize
    data class PhotoDetails(val photoId: String) : Destination()
}

/**
 * Models the navigation actions in the app.
 */
class Actions(navigator: Navigator<Destination>) {

    val selectPhoto: (String) -> Unit = { photoId ->
        navigator.navigate(Destination.PhotoDetails(photoId))
    }

    val pressOnBack: () -> Unit = {
        navigator.back()
    }
}