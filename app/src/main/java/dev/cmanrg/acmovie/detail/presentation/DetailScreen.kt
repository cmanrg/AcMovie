package dev.cmanrg.acmovie.detail.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.cmanrg.acmovie.detail.presentation.components.CoverImage
import dev.cmanrg.acmovie.detail.presentation.components.DetailTabs
import dev.cmanrg.acmovie.detail.presentation.components.MediaDetailsContent
import dev.cmanrg.acmovie.detail.presentation.components.RatingSection
import dev.cmanrg.acmovie.detail.presentation.components.StoryLine

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel()
) {
    val state = viewModel.state


    when {
        state.isLoading -> {
            CircularProgressIndicator()
        }

        state.error != null -> {
            Text("Error: ${state.error}")
        }

        state.detailMovie != null -> {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    CoverImage(
                        contentDescription = "",
                        isShowButtonPlay = true,
                        movieDetails = state.detailMovie
                    )
                }

                item {
                    RatingSection()
                }
                item {

                    MediaDetailsContent(
                        releaseDate = "January 9, 2025",
                        director = "Cesar Rios",
                        writers = "Jose Luis",
                        movieDetails = state.detailMovie
                    )
                }

                item {
                    StoryLine(movieDetails = state.detailMovie)
                }

                item {
                    DetailTabs(
                        movieSimilar = state.similarMovies,
                        movieRecommended = state.recommendationsMovies,
                    )
                }


            }
        }
    }


}