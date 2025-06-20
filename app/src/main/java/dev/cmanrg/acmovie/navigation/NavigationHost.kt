package dev.cmanrg.acmovie.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.cmanrg.acmovie.MainScreen


@Composable
fun NavigationHost(
    navHostController: NavHostController,
    startDestination: NavigationRoute,
) {

    NavHost(navController = navHostController, startDestination = startDestination.route) {

        composable(NavigationRoute.Onboarding.route) {
            Text(text = "Onboarding")
        }


        composable(NavigationRoute.MainScreen.route){
            MainScreen()
        }
    }

}