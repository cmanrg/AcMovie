package dev.cmanrg.acmovie.detail.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.cmanrg.acmovie.detail.data.remote.DetailApi
import dev.cmanrg.acmovie.detail.data.repository.DetailMovieRepositoryImpl
import dev.cmanrg.acmovie.detail.domain.repository.movie.DetailMovieRepository
import dev.cmanrg.acmovie.detail.domain.usecases.movie.DetailMovieUseCases
import dev.cmanrg.acmovie.detail.domain.usecases.movie.GetMovieDetailsUseCase
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DetailModule {


    @Provides
    @Singleton
    fun provideDetailRepository(api: DetailApi): DetailMovieRepository {
        return DetailMovieRepositoryImpl(api)
    }

    @Singleton
    @Provides
    fun provideDetailUseCases(repository: DetailMovieRepository): DetailMovieUseCases {
        return DetailMovieUseCases(
            getMovieDetailsUseCase = GetMovieDetailsUseCase(repository)
        )
    }

    @Provides
    @Singleton
    fun provideDetailApi(retrofit: Retrofit): DetailApi {
        return retrofit.create(DetailApi::class.java)
    }

}