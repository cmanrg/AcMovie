package dev.cmanrg.acmovie.navigation

sealed class NavigationRoute(val route: String) {
    data object Onboarding : NavigationRoute("onboarding")
    data object Login : NavigationRoute("login")
    data object MainScreen : NavigationRoute("mainscreen")
    data object Movie : NavigationRoute("movie")
    data object Detail : NavigationRoute("details")
}