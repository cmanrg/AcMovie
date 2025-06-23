package dev.cmanrg.acmovie.detail.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.cmanrg.acmovie.detail.domain.usecases.movie.DetailMovieUseCases
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: DetailMovieUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var state by mutableStateOf(DetailScreenUIState())
        private set

    init {
        // Extraemos el id
        val movieId: Int = checkNotNull(savedStateHandle["movieId"])
        // 2) Llamamos al caso de uso
        loadDetailMovie(movieId)
    }
    /*
    fun loadMovieDetail(movieId: Int, language: String = "en-US") {
        viewModelScope.launch {
            state = state.copy(isLoading = true, error = null)
            try {
                val movie = repository.getMovieDetailsUseCase(movieId, language)
                state = state.copy(detailMovie = movie, isLoading = false)
            } catch (e: Exception) {
                state = state.copy(
                    error = "Ocurrió un error al cargar los detalles",
                    isLoading = false
                )
            }
        }
    }*/

    fun loadDetailMovie(
        movieId: Int,
        page: Int = 1,
        language: String = "es-MX",
        region: String = "mx"
    ) {

        viewModelScope.launch {
            state = state.copy(isLoading = true, error = null)

            try {
                coroutineScope {
                    val detailData = async { repository.getMovieDetailsUseCase(movieId, language) }
                    val similarData = async {
                        repository.getMoviesRecommendationsUseCase(
                            movieId,
                            page,
                            language,
                            region
                        )
                    }
                    val recommendationsData = async {
                        repository.getSimilarMoviesUseCase(
                            movieId,
                            page,
                            language,
                            region
                        )
                    }

                    val detail = detailData.await()
                    val similar = similarData.await()
                    val recommendations = recommendationsData.await()

                    state = state.copy(
                        detailMovie = detail,
                        similarMovies = similar,
                        recommendationsMovies = recommendations,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                state = state.copy(
                    isLoading = false,
                    error = "Ocurrió un error al cargar las películas próximas"
                )
            }


        }


    }
}