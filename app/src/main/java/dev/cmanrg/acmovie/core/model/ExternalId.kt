package dev.cmanrg.acmovie.core.model

import androidx.annotation.DrawableRes
import dev.cmanrg.acmovie.R

sealed class ExternalId(@DrawableRes val drawableRes: Int) {
    data class Imdb(val id: String, val type: ExternalContentType) :
        ExternalId(drawableRes = R.drawable.ic_imdb)

    data class Facebook(val id: String, val type: ExternalContentType) :
        ExternalId(drawableRes = R.drawable.ic_facebook)

    data class Instagram(val id: String, val type: ExternalContentType) :
        ExternalId(drawableRes = R.drawable.ic_instagram)

    data class Twitter(val id: String, val type: ExternalContentType) :
        ExternalId(drawableRes = R.drawable.ic_twitter)
}

enum class ExternalContentType {
    Movie, Tv, Person;
}