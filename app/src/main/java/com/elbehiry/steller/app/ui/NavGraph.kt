package com.elbehiry.steller.app.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.elbehiry.steller.app.ui.main.MainContent


object MainDestinations {
    const val MAIN_ROUTE = "main"
    const val Main_ROUTE = "details"
}

@ExperimentalFoundationApi
@Composable
fun NavGraph(
    startDestination: String = MainDestinations.MAIN_ROUTE
) {
    val navController = rememberNavController()
    val actions = remember(navController) { MainActions(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable((MainDestinations.MAIN_ROUTE)) {
            MainContent{

            }
        }
    }
}

class MainActions(
    navController: NavHostController
) {
    val onDetailsContent: () -> Unit = {
        navController.navigate(
            route = MainDestinations.Main_ROUTE
        )
    }
}