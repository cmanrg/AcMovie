package dev.cmanrg.acmovie.movie.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.cmanrg.acmovie.R
import dev.cmanrg.acmovie.movie.presentation.components.Carousel
import dev.cmanrg.acmovie.movie.presentation.components.MovieSection

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieScreen(
    onMovieDetails: () -> Unit,
    onSeeAllMovies: () -> Unit,
    viewModel: MovieViewModel = hiltViewModel()
) {

    val state = viewModel.state

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets(0, 0, 0, 0)    // <— aquí

    ) { innerPadding ->

        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)

            ) {

                item {
                    Carousel(
                        movies = state.nowPlayingMovies,
                        modifier = Modifier
                            .height(500.dp),
                        onMovieClick = {}
                    )
                }


                item {
                    MovieSection(
                        title = stringResource(R.string.movie_upcoming),
                        movie = state.upcomingMovies,
                        onMovieClick = { onMovieDetails },
                        onSeeAllClick = {}
                    )
                }

                item {
                    MovieSection(
                        title = stringResource(R.string.movie_popular),
                        movie = state.popularMovies,
                        onMovieClick = { onMovieDetails },
                        onSeeAllClick = {}
                    )
                }

                item {
                    MovieSection(
                        title = stringResource(R.string.movie_top_rated),
                        movie = state.topRatedMovies,
                        onMovieClick = { onMovieDetails },
                        onSeeAllClick = {}
                    )
                }

            }



            //AppHeaderWithTabs()
        }

    }
}

@Preview(showSystemUi = true)
@Composable()
fun HomeScreenPreview() {
    MovieScreen(
        onMovieDetails = {},
        onSeeAllMovies = {}
    )
}