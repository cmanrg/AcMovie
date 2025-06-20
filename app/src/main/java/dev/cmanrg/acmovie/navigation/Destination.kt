package dev.cmanrg.acmovie.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.SmartDisplay
import androidx.compose.material.icons.filled.ZoomIn
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Movie
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.SmartDisplay
import androidx.compose.ui.graphics.vector.ImageVector
import dev.cmanrg.acmovie.R

enum class Destination(
    val route: String,
    @StringRes val label: Int,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    @StringRes val contentDescription: Int
) {
    MOVIE("movie", R.string.navigation_item_movie, Icons.Filled.Movie,Icons.Outlined.Movie ,R.string.navigation_item_movie),
    TV_SHOW("tvshow", R.string.navigation_item_tvshow, Icons.Filled.SmartDisplay,Icons.Outlined.SmartDisplay, R.string.navigation_item_tvshow),
    FAVORITE("favorite", R.string.navigation_item_favorite, Icons.Filled.Favorite, Icons.Outlined.FavoriteBorder,R.string.navigation_item_favorite),
    SEARCH("search", R.string.navigation_item_search, Icons.Filled.ZoomIn, Icons.Outlined.Search,R.string.navigation_item_search),
}