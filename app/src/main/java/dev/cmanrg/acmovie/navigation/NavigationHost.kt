package dev.cmanrg.acmovie.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import dev.cmanrg.acmovie.MainScreen
import dev.cmanrg.acmovie.detail.presentation.DetailScreen


@Composable
fun NavigationHost(
    navHostController: NavHostController,
    startDestination: NavigationRoute,
) {

    NavHost(navController = navHostController, startDestination = startDestination.route) {

        composable(NavigationRoute.Onboarding.route) {
            Text(text = "Onboarding")
        }

        composable(NavigationRoute.Login.route) {
            Text(text = "Login")
        }


        composable(NavigationRoute.MainScreen.route) {
            MainScreen(navController = navHostController)
        }

        // Detalle
        composable(
            route = NavigationRoute.Detail.route + "movieId={movieId}",
            arguments = listOf(
                navArgument("movieId") {
                    type = NavType.IntType
                    nullable = false
                    defaultValue = -1
                })
        ) {
            DetailScreen()
        }


    }
}

/*
NavHost(navController = navHostController, startDestination = startDestination.route) {

    composable(NavigationRoute.Onboarding.route) {
        Text(text = "Onboarding")
    }


    composable(NavigationRoute.MainScreen.route) {
        MainScreen()
    }

    composable(NavigationRoute.DetailsScreen.route) {
        DetailScreen()
    }
}*/

