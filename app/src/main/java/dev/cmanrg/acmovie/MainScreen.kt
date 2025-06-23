package dev.cmanrg.acmovie

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.cmanrg.acmovie.movie.presentation.MovieScreen
import dev.cmanrg.acmovie.navigation.Destination
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import dev.cmanrg.acmovie.navigation.NavigationRoute


@Composable
fun MainScreen(
    navController: NavHostController,
) {
    // 1. Controlador para las pestañas
    val innerNavController = rememberNavController()

    // 2. Lista de destinos del BottomNav
    val bottomItems = listOf(
        Destination.MOVIE, Destination.TV_SHOW, Destination.SEARCH, Destination.FAVORITE
    )


    Scaffold(
        bottomBar = {
            val navBackStackEntry by innerNavController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            NavigationBar {
                bottomItems.forEach { item ->
                    val selected = currentRoute == item.route

                    AcMovieNavBarItem(
                        label = stringResource(item.label),
                        selected = selected,
                        onClick = {
                            innerNavController.navigate(item.route) {
                                launchSingleTop = true
                                restoreState = true
                                popUpTo(innerNavController.graph.startDestinationId) {
                                    saveState = true
                                }
                            }
                        },
                        selectedIcon = item.selectedIcon,
                        unSelectedIcon = item.unSelectedIcon,
                        contentDescription = stringResource(item.contentDescription)

                    )
                }
            }
        }) { paddingValues ->
        // 3. NavHost interno para las pantallas de cada pestaña
        NavHost(
            navController = innerNavController,
            startDestination = Destination.MOVIE.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            bottomItems.forEach { dest ->
                composable(dest.route) {
                    when (dest) {
                        Destination.MOVIE -> MovieScreen(
                            onMovieDetails = { movieId ->
                                // Usa el NavController PRINCIPAL para navegar a pantallas FUERA del BottomNav
                                navController.navigate(NavigationRoute.Detail.route + "movieId=$movieId")
                            },
                            onSeeAllMovies = { /*…*/ })

                        Destination.TV_SHOW -> Text(text = "TV Show")
                        Destination.SEARCH -> Text(text = "Search")
                        Destination.FAVORITE -> Text(text = "Favorite")
                    }
                }
            }
        }
    }
}

@Composable
fun RowScope.AcMovieNavBarItem(
    label: String,
    selected: Boolean,
    onClick: () -> Unit = {},
    selectedIcon: ImageVector,
    unSelectedIcon: ImageVector,
    contentDescription: String? = null,
) {

    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        colors = NavigationBarItemDefaults.colors(
            indicatorColor = MaterialTheme.colorScheme.primaryContainer,
            selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
            unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
            selectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
            unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,

            ),
        label = {
            Text(label)
        },
        icon = {
            Icon(
                imageVector = if (selected) selectedIcon else unSelectedIcon,
                contentDescription = contentDescription
            )
        }
    )

}
