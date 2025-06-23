package dev.cmanrg.acmovie.detail.domain.usecases.movie

data class DetailMovieUseCases(
    val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    val getSimilarMoviesUseCase: GetMovieSimilarUseCase,
    val getMoviesRecommendationsUseCase: GetMoviesRecommendationsUseCase
)
