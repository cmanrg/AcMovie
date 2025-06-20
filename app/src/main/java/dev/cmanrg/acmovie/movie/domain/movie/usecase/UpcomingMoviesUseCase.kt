package dev.cmanrg.acmovie.movie.domain.movie.usecase

import dev.cmanrg.acmovie.movie.domain.models.Movie
import dev.cmanrg.acmovie.movie.domain.repository.MovieRepository

class UpcomingMoviesUseCase(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(
        page: Int,
        language: String,
        region: String
    ): List<Movie> {

        return repository.getUpcomingMovies(
            page = page,
            language = language,
            region = region
        )
    }
}