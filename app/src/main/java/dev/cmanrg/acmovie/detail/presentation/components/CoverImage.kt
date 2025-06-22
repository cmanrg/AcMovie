package dev.cmanrg.acmovie.detail.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.cmanrg.acmovie.detail.domain.model.MovieDetails

@Composable
fun CoverImage(
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    isShowButtonPlay: Boolean,
    movieDetails: MovieDetails
) {

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val desiredHeight = screenHeight * 0.6f
    Box(
        modifier = modifier
            .height(desiredHeight)  // Altura fija: 60% de la pantalla
            .systemBarsPadding()
            .background(Color.Black),
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxSize(),
            model = movieDetails.backdropPath,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop
        )

        BottomGradient(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            height = 100.dp

        )
        CoverSummary(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            title = movieDetails.title,
            tagline = movieDetails.tagline,
            runtime = "1h 44min",
            adult = true,
            genres = movieDetails.genres.map { it.name },
        )


    }

}

