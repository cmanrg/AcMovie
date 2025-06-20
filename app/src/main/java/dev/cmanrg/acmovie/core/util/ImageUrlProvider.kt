package dev.cmanrg.acmovie.core.util

object ImageUrlProvider {

    private const val BASE_URL_IMAGE = "https://image.tmdb.org/t/p/"
    private const val ORIGINAL_SIZE = "original"

    fun getFullUrl(path: String?, size: String = ORIGINAL_SIZE): String? {
        return path?.let { "$BASE_URL_IMAGE$size$it" }
    }
}