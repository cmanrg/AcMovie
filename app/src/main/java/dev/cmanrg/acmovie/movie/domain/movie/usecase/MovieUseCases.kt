package dev.cmanrg.acmovie.movie.domain.movie.usecase

data class MovieUseCases(
    val getUpcomingMovies: UpcomingMoviesUseCase,
    val getNowPlayingMovies: NowPlayingMoviesUseCase,
    val getPopularMovies: PopularMoviesUseCase,
    val getTopRatedMovies: TopRatedMoviesUseCase
)
