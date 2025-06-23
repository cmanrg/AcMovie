package dev.cmanrg.acmovie.detail.domain.repository.movie

import dev.cmanrg.acmovie.detail.domain.model.MovieDetails
import dev.cmanrg.acmovie.detail.domain.model.MovieResponse

interface DetailMovieRepository {
    suspend fun getDetailsMovie(movieId: Int, language: String): MovieDetails
    suspend fun getSimilarMovies(movieId: Int, page: Int, language: String, region: String): List<MovieResponse>
    suspend fun getMoviesRecommendations(movieId: Int, page: Int, language: String, region: String): List<MovieResponse>
}