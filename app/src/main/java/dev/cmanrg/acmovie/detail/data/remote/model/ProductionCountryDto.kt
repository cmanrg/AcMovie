package dev.cmanrg.acmovie.detail.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductionCountryDto(
    @Json(name = "iso_3166_1")
    val iso: String,
    val name: String
)
