package dev.cmanrg.acmovie.detail.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.cmanrg.acmovie.detail.domain.usecases.movie.DetailMovieUseCases
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: DetailMovieUseCases
): ViewModel() {

    var uiState by mutableStateOf(DetailScreenUIState())
        private set

    init {
        loadMovieDetail(1022789,"es-MX")
    }

    fun loadMovieDetail(movieId: Int, language: String = "en-US") {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true, error = null)
            try {
                val movie = repository.getMovieDetailsUseCase(movieId, language)
                uiState = uiState.copy(detailMovie = movie, isLoading = false)
            } catch (e: Exception) {
                uiState = uiState.copy(error = "Ocurrió un error al cargar los detalles", isLoading = false)
            }
        }
    }
}