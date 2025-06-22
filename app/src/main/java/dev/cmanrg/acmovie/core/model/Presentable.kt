package dev.cmanrg.acmovie.core.model

import androidx.compose.runtime.Stable

@Stable
interface Presentable {
    val id: Int
    val title: String
    val posterPath: String?
}

@Stable
interface DetailPresentable : Presentable {
    val adult: Boolean?
    val overview: String?
    val backdropPath: String?
    val voteAverage: Double
    val voteCount: Int
}