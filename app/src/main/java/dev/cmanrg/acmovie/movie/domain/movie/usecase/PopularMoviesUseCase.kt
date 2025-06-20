package dev.cmanrg.acmovie.movie.domain.movie.usecase

import dev.cmanrg.acmovie.movie.domain.models.Movie
import dev.cmanrg.acmovie.movie.domain.repository.MovieRepository

class PopularMoviesUseCase(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(): List<Movie> {
        return repository.getPopularMovies()
    }


}