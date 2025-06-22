package dev.cmanrg.acmovie.detail.domain.model

import dev.cmanrg.acmovie.detail.data.remote.model.MovieStatus
import dev.cmanrg.acmovie.detail.data.remote.model.ProductionCountryDto
import java.util.Date

data class MovieDetails(
    val id: Int,
    val backdropPath: String?,
    val budget: Long,
    val genres: List<Genre>,
    val homepage: String?,
    val imdbId: String?,
    val originalTitle: String,
    val overview: String,
    val popularity: Float,
    val posterPath: String?,
    val productionCompanies: List<ProductionCompany>,
    val productionCountries: List<ProductionCountryDto>,
    val releaseDate: String?,
    val revenue: Long,
    val runtime: Int?,
    val status: String,
    val tagline: String?,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)
