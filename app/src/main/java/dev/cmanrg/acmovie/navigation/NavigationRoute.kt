package dev.cmanrg.acmovie.navigation

sealed class NavigationRoute(val route: String) {
    data object Onboarding: NavigationRoute("onboarding")
    data object MainScreen: NavigationRoute("mainscreen")

}