package dev.cmanrg.acmovie.core.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GenresResponse(
    val genres: List<GenreDto>
)