package dev.cmanrg.acmovie.detail.data.repository

import dev.cmanrg.acmovie.detail.data.mapper.toDomain
import dev.cmanrg.acmovie.detail.data.remote.DetailApi
import dev.cmanrg.acmovie.detail.domain.model.MovieDetails
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


}