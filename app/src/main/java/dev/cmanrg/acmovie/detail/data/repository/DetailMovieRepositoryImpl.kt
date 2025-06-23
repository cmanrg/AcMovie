package dev.cmanrg.acmovie.detail.data.repository

import dev.cmanrg.acmovie.core.model.MoviesResponse
import dev.cmanrg.acmovie.detail.data.mapper.toDomain
import dev.cmanrg.acmovie.detail.data.remote.DetailApi
import dev.cmanrg.acmovie.detail.domain.model.MovieDetails
import dev.cmanrg.acmovie.detail.domain.model.MovieResponse
import dev.cmanrg.acmovie.detail.domain.repository.movie.DetailMovieRepository

class DetailMovieRepositoryImpl (
    private val api: DetailApi
) : DetailMovieRepository {
    override suspend fun getDetailsMovie(
        movieId: Int,
        language: String
    ): MovieDetails {
        return api.getMovieDetails(movieId,language).toDomain()
    }

    override suspend fun getSimilarMovies(
        movieId: Int,
        page: Int,
        language: String,
        region: String
    ): List<MovieResponse> {
        return api.getSimilarMovies(movieId, page, language, region).movies.map { it.toDomain() }
    }

    override suspend fun getMoviesRecommendations(
        movieId: Int,
        page: Int,
        language: String,
        region: String
    ): List<MovieResponse> {
        return api.getMoviesRecommendations(movieId, page, language, region).movies.map { it.toDomain() }
    }


}