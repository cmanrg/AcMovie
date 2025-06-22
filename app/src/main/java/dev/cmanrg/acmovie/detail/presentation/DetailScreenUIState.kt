package dev.cmanrg.acmovie.detail.presentation

import dev.cmanrg.acmovie.detail.domain.model.MovieDetails

data class DetailScreenUIState(
    val isLoading: Boolean = false,
    val detailMovie: MovieDetails? = null,
    val error: String? = null

)
