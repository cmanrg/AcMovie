package dev.cmanrg.acmovie.detail.domain.usecases.movie

import dev.cmanrg.acmovie.detail.domain.model.MovieDetails
import dev.cmanrg.acmovie.detail.domain.repository.movie.DetailMovieRepository

class GetMovieDetailsUseCase(private val repository: DetailMovieRepository) {
    suspend operator fun invoke(movieId: Int, language: String): MovieDetails {
        return repository.getDetailsMovie(movieId, language)
    }
}