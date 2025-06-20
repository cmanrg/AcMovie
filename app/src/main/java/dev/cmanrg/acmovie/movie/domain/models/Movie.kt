package dev.cmanrg.acmovie.movie.domain.models

data class Movie(
    val id: Int,
    val posterPath: String?,
    val adult: Boolean?,
    val overview: String,
    val releaseDate: String?,
    val originalTitle: String,
    val backdropPath: String?,
    val popularity: Double?,
    val voteCount: Int,
    val voteAverage: Double
)
