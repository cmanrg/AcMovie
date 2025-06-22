package dev.cmanrg.acmovie.detail.data.remote

import dev.cmanrg.acmovie.core.model.AllWatchProvidersResponse
import dev.cmanrg.acmovie.core.model.ExternalIds
import dev.cmanrg.acmovie.core.model.GenresResponse
import dev.cmanrg.acmovie.core.model.ImagesResponse
import dev.cmanrg.acmovie.core.model.ReviewsResponse
import dev.cmanrg.acmovie.core.model.VideosResponse
import dev.cmanrg.acmovie.core.model.WatchProvidersResponse
import dev.cmanrg.acmovie.detail.data.remote.model.Credits
import dev.cmanrg.acmovie.detail.data.remote.model.MovieDetailsDto
import dev.cmanrg.acmovie.movie.data.remote.model.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DetailApi {

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("language") isoCode: String
    ): MovieDetailsDto

    @GET("movie/{movie_id}/credits")
    fun getMovieCredits(
        @Path("movie_id") movieId: Int,
        @Query("language") isoCode: String
    ): Call<Credits>

    @GET("movie/{movie_id}/similar")
    suspend fun getSimilarMovies(
        @Path("movie_id") movieId: Int,
        @Query("page") page: Int,
        @Query("language") isoCode: String,
        @Query("region") region: String
    ): MoviesResponse

    @GET("movie/{movie_id}/recommendations")
    suspend fun getMoviesRecommendations(
        @Path("movie_id") movieId: Int,
        @Query("page") page: Int,
        @Query("language") isoCode: String,
        @Query("region") region: String
    ): MoviesResponse

    @GET("trending/movie/week")
    suspend fun getTrendingMovies(
        @Query("page") page: Int,
        @Query("language") isoCode: String,
        @Query("region") region: String
    ): MoviesResponse

    @GET("movie/{movie_id}/images")
    fun getMovieImages(
        @Path("movie_id") movieId: Int
    ): Call<ImagesResponse>

    @GET("movie/{movie_id}/reviews")
    suspend fun getMovieReviews(
        @Path("movie_id") movieId: Int,
        @Query("page") page: Int
    ): ReviewsResponse

    @GET("movie/{movie_id}/reviews")
    fun getMovieReview(
        @Path("movie_id") movieId: Int
    ): Call<ReviewsResponse>

    @GET("genre/movie/list")
    fun getMovieGenres(
        @Query("language") isoCode: String
    ): Call<GenresResponse>

    @GET("movie/{movie_id}/watch/providers")
    fun getMovieWatchProviders(
        @Path("movie_id") movieId: Int
    ): Call<WatchProvidersResponse>

    @GET("movie/{movie_id}/external_ids")
    fun getMovieExternalIds(
        @Path("movie_id") movieId: Int,
    ): Call<ExternalIds>

    @GET("watch/providers/movie")
    fun getAllMoviesWatchProviders(
        @Query("language") isoCode: String,
        @Query("watch_region") region: String
    ): Call<AllWatchProvidersResponse>

    @GET("movie/{movie_id}/videos")
    fun getMovieVideos(
        @Path("movie_id") movieId: Int,
        @Query("language") isoCode: String
    ): Call<VideosResponse>

    @GET("discover/movie")
    suspend fun getOtherMoviesOfDirector(
        @Query("page") page: Int,
        @Query("language") isoCode: String,
        @Query("region") region: String,
        @Query("with_crew") directorId: Int
    ): MoviesResponse
}