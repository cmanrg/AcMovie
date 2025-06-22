package dev.cmanrg.acmovie.detail.data.remote.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CastMember(
    val adult: Boolean,
    val gender: Int?,
)
