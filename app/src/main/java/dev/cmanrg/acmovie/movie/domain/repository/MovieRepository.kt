package dev.cmanrg.acmovie.movie.domain.repository

import dev.cmanrg.acmovie.movie.domain.models.Movie

interface MovieRepository {
    suspend fun getNowPlayingMovies(): List<Movie>
    suspend fun getTopRatedMovies(): List<Movie>
    suspend fun getUpcomingMovies(
        page: Int,
        language: String,
        region: String
    ): List<Movie>
    suspend fun getPopularMovies(): List<Movie>
}