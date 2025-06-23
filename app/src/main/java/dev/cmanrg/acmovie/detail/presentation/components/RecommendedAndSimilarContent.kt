package dev.cmanrg.acmovie.detail.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.cmanrg.acmovie.R
import dev.cmanrg.acmovie.detail.domain.model.MovieResponse
import dev.cmanrg.acmovie.ui.components.NoResultComponent
import dev.cmanrg.acmovie.ui.components.PosterCard

@Composable
fun RecommendedAndSimilarContent(
    modifier: Modifier = Modifier,
    movieSimilar: List<MovieResponse>,
    movieRecommended: List<MovieResponse>,
    onClickListener: () -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 25.dp, bottom = 20.dp)
    ) {

        if (movieSimilar.isEmpty() && movieRecommended.isEmpty()) {
            NoResultComponent()
        }

        if (movieSimilar.isNotEmpty()) {
            TitleContent(title = stringResource(R.string.similar_movies))
            LazyRowItem(posterMovie = movieSimilar)
        }


        if (movieRecommended.isNotEmpty()) {
            TitleContent(title = stringResource(R.string.recommendations))
            LazyRowItem(posterMovie = movieRecommended)
        }


    }

}

@Composable
fun LazyRowItem(
    posterMovie: List<MovieResponse>
) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        itemsIndexed(posterMovie) { index, movie ->
            PosterCardItem(
                image = movie.posterPath ?: ""
            )
        }

    }
}

@Composable
fun PosterCardItem(
    modifier: Modifier = Modifier,
    image: String,
) {
    PosterCard(
        modifier = modifier.padding(bottom = 16.dp),
        image = image
    )
}

@Composable
fun TitleContent(
    modifier: Modifier = Modifier,
    title: String,
) {

    Text(
        title,
        style = MaterialTheme.typography.headlineLarge.copy(
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = MaterialTheme.typography.titleSmall.fontSize,
            fontWeight = FontWeight.Bold
        ),
        modifier = modifier
            .padding(bottom = 20.dp)
    )

}


