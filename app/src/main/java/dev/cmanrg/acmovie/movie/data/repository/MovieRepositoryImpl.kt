package dev.cmanrg.acmovie.movie.data.repository

import dev.cmanrg.acmovie.movie.data.mapper.toDomain
import dev.cmanrg.acmovie.movie.data.remote.movie.TmdbMoviesApi
import dev.cmanrg.acmovie.movie.domain.models.Movie
import dev.cmanrg.acmovie.movie.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val api: TmdbMoviesApi
) : MovieRepository {


    override suspend fun getNowPlayingMovies(): List<Movie> {
        return api.getNowPlayingMovies(
            page = 1, // Cambiar estos valores
            isoCode = "en-US", region = "US"
        ).movies.map { it.toDomain() }
    }

    override suspend fun getTopRatedMovies(): List<Movie> {
        return api.getTopRatedMovies(
            page = 1, // Cambiar estos valores
            isoCode = "en-US", region = "US"
        ).movies.map { it.toDomain() }
    }

    override suspend fun getUpcomingMovies(
        page: Int, language: String, region: String
    ): List<Movie> {
        return api.getUpcomingMovies(
            page = page, isoCode = language, region = region
        ).movies.map { it.toDomain() }/*
        return try {
            val response = api.getUpcomingMovies(page, language, region)
            Log.d("Repository", "Películas recibidas: ${response.movies.size}")
            response.movies.map { it.toDomain() }
        } catch (e: Exception) {
            Log.e("Repository", "Error al obtener películas: ${e.message}", e)
            throw e // re-lanza para que el ViewModel lo capture
        }*/
    }


    override suspend fun getPopularMovies(): List<Movie> {
        return api.getPopularMovies(
            page = 1, // Cambiar estos valores
            isoCode = "en-US", region = "US"
        ).movies.map { it.toDomain() }
    }
}