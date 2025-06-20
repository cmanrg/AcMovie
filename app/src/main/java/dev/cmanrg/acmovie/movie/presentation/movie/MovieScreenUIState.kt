package dev.cmanrg.acmovie.movie.presentation.movie

import dev.cmanrg.acmovie.movie.domain.models.Movie

data class MovieScreenUIState(
    val nowPlayingMovies: List<Movie> = emptyList(),
    val upcomingMovies: List<Movie> = emptyList(),
    val popularMovies: List<Movie> = emptyList(),
    val topRatedMovies: List<Movie> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
