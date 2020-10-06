package com.elbehiry.steller.app.ui.main

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.savedinstancestate.rememberSavedInstanceState
import com.elbehiry.steller.app.ui.Actions
import com.elbehiry.steller.app.ui.Destination
import com.elbehiry.steller.app.ui.photos.Photos
import com.elbehiry.steller.app.ui.photos.StellerHomeTab
import com.elbehiry.steller.app.ui.util.BackDispatcherAmbient
import com.elbehiry.steller.app.ui.util.Navigator
import com.elbehiry.steller.app.ui.util.ProvideDisplayInsets

@Composable
fun stellerMain(viewModel: MainViewModel, backDispatcher: OnBackPressedDispatcher) {

    val navigator: Navigator<Destination> = rememberSavedInstanceState(
        saver = Navigator.saver(backDispatcher)
    ) {
        Navigator(Destination.Home, backDispatcher)
    }

    val action = remember(navigator) { Actions(navigator) }
    val (selectedTab, setSelectedTab) = remember { mutableStateOf(StellerHomeTab.HOME) }

    Providers(BackDispatcherAmbient provides backDispatcher) {
        ProvideDisplayInsets {
            Crossfade(navigator.current) { destination ->
                when (destination) {
                    Destination.Home -> Photos(
                        viewModel = viewModel,
                        selectPhoto = action.selectPhoto,
                        selectedTab = selectedTab,
                        setSelectedTab = setSelectedTab
                    )

                    is Destination.PhotoDetails -> {
                        //TODO:Tobe Handled (open detail screen with the image details).
                    }
                }
            }
        }
    }
}