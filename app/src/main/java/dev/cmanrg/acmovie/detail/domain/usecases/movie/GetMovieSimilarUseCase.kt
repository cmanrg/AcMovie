package dev.cmanrg.acmovie.detail.domain.usecases.movie

import dev.cmanrg.acmovie.detail.domain.model.MovieResponse
import dev.cmanrg.acmovie.detail.domain.repository.movie.DetailMovieRepository


class GetMovieSimilarUseCase(
    private val repository: DetailMovieRepository

) {

    suspend operator fun invoke(movieId: Int, page: Int, language: String, region: String): List<MovieResponse> {
        return repository.getSimilarMovies(movieId, page, language, region)
    }



}