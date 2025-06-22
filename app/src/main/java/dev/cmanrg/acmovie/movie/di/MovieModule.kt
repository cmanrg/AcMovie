package dev.cmanrg.acmovie.movie.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.cmanrg.acmovie.movie.data.remote.movie.MovieApi
import dev.cmanrg.acmovie.movie.data.repository.MovieRepositoryImpl
import dev.cmanrg.acmovie.movie.domain.movie.usecase.MovieUseCases
import dev.cmanrg.acmovie.movie.domain.movie.usecase.NowPlayingMoviesUseCase
import dev.cmanrg.acmovie.movie.domain.movie.usecase.PopularMoviesUseCase
import dev.cmanrg.acmovie.movie.domain.movie.usecase.TopRatedMoviesUseCase
import dev.cmanrg.acmovie.movie.domain.movie.usecase.UpcomingMoviesUseCase
import dev.cmanrg.acmovie.movie.domain.repository.MovieRepository
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieModule {


    @Provides
    @Singleton
    fun provideMovieRepository(api: MovieApi): MovieRepository {
        return MovieRepositoryImpl(api)
    }

    @Singleton
    @Provides
    fun provideMovieUseCases(repository: MovieRepository): MovieUseCases {
        return MovieUseCases(
            getUpcomingMovies = UpcomingMoviesUseCase(repository),
            getNowPlayingMovies = NowPlayingMoviesUseCase(repository),
            getPopularMovies = PopularMoviesUseCase(repository),
            getTopRatedMovies = TopRatedMoviesUseCase(repository)
        )

    }


    @Singleton
    @Provides
    fun provideMovieApi(retrofit: Retrofit): MovieApi {
        return retrofit.create(MovieApi::class.java)
    }


}