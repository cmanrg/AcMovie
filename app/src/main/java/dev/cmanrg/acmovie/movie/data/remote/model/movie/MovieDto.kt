package dev.cmanrg.acmovie.movie.data.remote.model.movie

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

// ESTE SERIA EL ARCHIVO MOVIEDTO
@JsonClass(generateAdapter = true)
data class MovieDto(
    val id: Int,
    @Json(name = "poster_path")
    val posterPath: String?,
    val adult: Boolean?,
    val overview: String,
    @Json(name = "release_date")
    val releaseDate: String?,
    @Json(name = "genre_ids")
    val genreIds: List<Int>,
    @Json(name = "original_title")
    val originalTitle: String,
    @Json(name = "original_language")
    val originalLanguage: String,
    val title: String,
    @Json(name = "backdrop_path")
    val backdropPath: String?,
    val popularity: Double?,
    @Json(name = "vote_count")
    val voteCount: Int,
    val video: Boolean,
    @Json(name = "vote_average")
    val voteAverage: Double
)