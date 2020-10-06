package com.elbehiry.steller.app.ui.main

import android.os.Bundle
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.elbehiry.steller.app.ui.theme.stellerComposeTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    @VisibleForTesting
    val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getImages()

        setContent {
            stellerComposeTheme {
                stellerMain(viewModel, onBackPressedDispatcher)
            }
        }
    }
}
