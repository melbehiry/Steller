package com.elbehiry.steller.app.ui.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import com.elbehiry.steller.app.ui.NavGraph
import com.elbehiry.steller.app.ui.theme.stellerComposeTheme
import com.google.accompanist.insets.ProvideWindowInsets

class MainActivity : AppCompatActivity() {

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            stellerComposeTheme {
                ProvideWindowInsets {
                    NavGraph()
                }
            }
        }
    }
}
