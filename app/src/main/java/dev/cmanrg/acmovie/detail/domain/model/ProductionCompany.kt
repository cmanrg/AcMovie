package dev.cmanrg.acmovie.detail.domain.model


data class ProductionCompany(
    val name: String,
    val id: Int,
    val logoPath: String?,
    val originCountry: String,
    val logoUrl: String? = null
)
