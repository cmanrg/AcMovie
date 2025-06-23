package dev.cmanrg.acmovie.detail.presentation

import dev.cmanrg.acmovie.detail.domain.model.MovieDetails
import dev.cmanrg.acmovie.detail.domain.model.MovieResponse

data class DetailScreenUIState(
    val isLoading: Boolean = false,
    val detailMovie: MovieDetails? = null,
    val similarMovies: List<MovieResponse> = emptyList(),
    val recommendationsMovies: List<MovieResponse> = emptyList(),
    val error: String? = null

)
