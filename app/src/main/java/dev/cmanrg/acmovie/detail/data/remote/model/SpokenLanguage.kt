package dev.cmanrg.acmovie.detail.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpokenLanguage(
    val english_name: String,
    @Json(name = "iso_639_1")
    val iso: String,
    val name: String
)
