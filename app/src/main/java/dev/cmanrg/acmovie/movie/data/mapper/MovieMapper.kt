package dev.cmanrg.acmovie.movie.data.mapper

import dev.cmanrg.acmovie.core.util.ImageUrlProvider
import dev.cmanrg.acmovie.core.model.MovieDto
import dev.cmanrg.acmovie.movie.domain.models.Movie

fun MovieDto.toDomain(): Movie{
    return Movie(
        id = id,
        posterPath = ImageUrlProvider.getFullUrl(posterPath, "w500"),
        adult = adult,
        overview = overview,
        releaseDate = releaseDate,
        originalTitle = originalTitle,
        backdropPath = ImageUrlProvider.getFullUrl(backdropPath, "original"),
        popularity = popularity,
        voteCount = voteCount,
        voteAverage = voteAverage
    )
}