package dev.cmanrg.acmovie.detail.domain.usecases.movie

import dev.cmanrg.acmovie.core.model.MoviesResponse
import dev.cmanrg.acmovie.detail.domain.model.MovieDetails
import dev.cmanrg.acmovie.detail.domain.model.MovieResponse
import dev.cmanrg.acmovie.detail.domain.repository.movie.DetailMovieRepository

class GetMoviesRecommendationsUseCase(
    private val repository: DetailMovieRepository

) {
    suspend operator fun invoke(movieId: Int, page: Int, language: String, region: String): List<MovieResponse> {
        return repository.getMoviesRecommendations(movieId, page, language, region)
    }
}