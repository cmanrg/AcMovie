package dev.cmanrg.acmovie.movie.presentation.movie.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.cmanrg.acmovie.core.presentation.components.AcMovieTitle
import dev.cmanrg.acmovie.core.presentation.components.PosterCard
import dev.cmanrg.acmovie.movie.domain.models.Movie

@Composable
fun MovieSection(
    movie: List<Movie>,
    modifier: Modifier = Modifier,
    title: String,
    onMovieClick: () -> Unit,
    onSeeAllClick: () -> Unit
) {

    Column(
        modifier = modifier
            .padding(vertical = 8.dp)
    ) {
        AcMovieTitle(
            title = title,
            onSeeAllClick = {
                onSeeAllClick()
            })

        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(movie) { index, movies ->
                PosterCard(
                    image = movies.posterPath ?: "",
                    onClick = { onMovieClick() }
                )
            }
        }
    }

}