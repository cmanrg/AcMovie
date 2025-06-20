package dev.cmanrg.acmovie.core.network.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.cmanrg.acmovie.core.network.interceptor.AuthInterceptor
import dev.cmanrg.acmovie.core.network.constants.AcMovieApi
import dev.cmanrg.acmovie.movie.data.remote.movie.TmdbMoviesApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideAuthInterceptor(): Interceptor {
        return AuthInterceptor {
            // Aquí devuelves el token; por ahora fijo, pero puede venir de DataStore o similar
            "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5MDc5Mjg2OTFhNmUwOGFjZDBkOTllZTE1YWQ1ZTMwMiIsIm5iZiI6MTU5NTg4MjU4Mi4wNzksInN1YiI6IjVmMWYzYzU2Njg4Y2QwMDAzN2Y5OGI0YyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.YiAZ8uqpc7C2eQE8Iu_kZxHdYM25Ub8V3N7RBg6o-D4"
        }
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(authInterceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory()) // <-- NECESARIO para @JsonClass(generateAdapter = true)
            .build()
    }


    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl(AcMovieApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieApi(retrofit: Retrofit): TmdbMoviesApi {
        return retrofit.create(TmdbMoviesApi::class.java)
    }

}