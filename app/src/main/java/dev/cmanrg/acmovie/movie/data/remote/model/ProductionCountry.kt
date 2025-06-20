package dev.cmanrg.acmovie.movie.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductionCountry(
    @Json(name = "iso_3166_1")
    val iso: String,
    val name: String
)
