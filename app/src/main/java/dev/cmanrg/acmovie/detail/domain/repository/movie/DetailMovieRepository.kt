package dev.cmanrg.acmovie.detail.domain.repository.movie

import dev.cmanrg.acmovie.detail.domain.model.MovieDetails

interface DetailMovieRepository {
    suspend fun getDetailsMovie(movieId: Int, language: String): MovieDetails
}