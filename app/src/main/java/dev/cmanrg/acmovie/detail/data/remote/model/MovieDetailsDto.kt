package dev.cmanrg.acmovie.detail.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import dev.cmanrg.acmovie.core.model.DetailPresentable
import dev.cmanrg.acmovie.core.model.GenreDto
import java.util.Date

@JsonClass(generateAdapter = true)
data class MovieDetailsDto(
    override val id: Int,
    override val adult: Boolean,
    @Json(name = "backdrop_path")
    override val backdropPath: String?,
    val budget: Long,
    val genres: List<GenreDto>,
    val homepage: String?,
    @Json(name = "imdb_id")
    val imdbId: String?,
    @Json(name = "belongs_to_collection")
    val collection: Collection?,
    @Json(name = "original_language")
    val originalLanguage: String,
    @Json(name = "original_title")
    val originalTitle: String,
    override val overview: String,
    val popularity: Float,
    @Json(name = "poster_path")
    override val posterPath: String?,
    @Json(name = "production_companies")
    val productionCompanies: List<ProductionCompanyDto>,
    @Json(name = "production_countries")
    val productionCountries: List<ProductionCountryDto>,
    @Json(name = "release_date")
    val releaseDate: String?,
    val revenue: Long,
    val runtime: Int?,
    @Json(name = "spoken_languages")
    val spokenLanguages: List<SpokenLanguage>,
    val status: String,
    val tagline: String?,
    override val title: String,
    val video: Boolean,
    @Json(name = "vote_average")
    override val voteAverage: Double,
    @Json(name = "vote_count")
    override val voteCount: Int
) : DetailPresentable