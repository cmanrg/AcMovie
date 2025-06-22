package dev.cmanrg.acmovie.movie.data.remote.movie

import dev.cmanrg.acmovie.movie.data.remote.model.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(
     @Query("page") page: Int,
     @Query("language") isoCode: String,
     @Query("region") region: String
    ): MoviesResponse

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("page") page: Int,
        @Query("language") isoCode: String,
        @Query("region") region: String
    ): MoviesResponse

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("page") page: Int,
        @Query("language") isoCode: String,
        @Query("region") region: String
    ): MoviesResponse

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("page") page: Int,
        @Query("language") isoCode: String,
        @Query("region") region: String
    ): MoviesResponse



}