package dev.cmanrg.acmovie.detail.data.mapper

import dev.cmanrg.acmovie.core.model.GenreDto
import dev.cmanrg.acmovie.core.model.MovieDto
import dev.cmanrg.acmovie.core.util.ImageUrlProvider
import dev.cmanrg.acmovie.detail.data.remote.model.MovieDetailsDto
import dev.cmanrg.acmovie.detail.data.remote.model.ProductionCompanyDto
import dev.cmanrg.acmovie.detail.data.remote.model.ProductionCountryDto
import dev.cmanrg.acmovie.detail.domain.model.Genre
import dev.cmanrg.acmovie.detail.domain.model.MovieDetails
import dev.cmanrg.acmovie.detail.domain.model.MovieResponse
import dev.cmanrg.acmovie.detail.domain.model.ProductionCompany
import dev.cmanrg.acmovie.detail.domain.model.ProductionCountry


fun MovieDetailsDto.toDomain(): MovieDetails {


    return MovieDetails(
        id = id,
        backdropPath = ImageUrlProvider.getFullUrl(backdropPath, "original"),
        budget = budget,
        genres = genres.map { it.toDomain() },
        homepage = homepage,
        imdbId = imdbId,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = ImageUrlProvider.getFullUrl(posterPath, "w500"),
        productionCompanies = productionCompanies.map { it.toDomain() },
        productionCountries = productionCountries,
        releaseDate = releaseDate,
        revenue = revenue,
        runtime = runtime,
        status = status,
        tagline = tagline,
        title = title,
        video = video,
        voteAverage = voteAverage,
        voteCount = voteCount
    )


}

fun MovieDto.toDomain(): MovieResponse {
    return MovieResponse(
        posterPath = ImageUrlProvider.getFullUrl(posterPath, "w500")
    )
}

private fun GenreDto.toDomain(): Genre {
    return Genre(
        id = id,
        name = name
    )
}

private fun ProductionCompanyDto.toDomain(): ProductionCompany {
    return ProductionCompany(
        name = name,
        id = id,
        logoPath = logoPath,
        originCountry = originCountry

    )

}
