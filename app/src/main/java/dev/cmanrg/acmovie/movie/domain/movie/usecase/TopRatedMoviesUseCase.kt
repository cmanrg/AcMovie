package dev.cmanrg.acmovie.movie.domain.movie.usecase

import dev.cmanrg.acmovie.movie.domain.models.Movie
import dev.cmanrg.acmovie.movie.domain.repository.MovieRepository

class TopRatedMoviesUseCase(
    private val repository: MovieRepository
) {

    suspend operator fun invoke(): List<Movie> {
        return repository.getTopRatedMovies()
    }

}