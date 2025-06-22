package dev.cmanrg.acmovie.movie.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.cmanrg.acmovie.movie.domain.movie.usecase.MovieUseCases
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieUseCases: MovieUseCases
): ViewModel() {

    var state by mutableStateOf(MovieScreenUIState())
        private set



    init {
        loadUpcomingMovies()
    }

    // Función para cargar películas próximas
    fun loadUpcomingMovies(
        page: Int = 1,          // Valor por defecto para la página
        language: String = "en-US",  // Idioma por defecto
        region: String = "US"        // Región por defecto
    ) {
        viewModelScope.launch {
            state = state.copy(isLoading = true, error = null)
            try {
                coroutineScope {
                    val nowPlayingDeferred = async { movieUseCases.getNowPlayingMovies() }
                    val popularDeferred = async { movieUseCases.getPopularMovies() }
                    val topRatedDeferred = async { movieUseCases.getTopRatedMovies() }
                    val upcomingDeferred = async { movieUseCases.getUpcomingMovies(1, "en-US", "US") }

                    // Esperar resultados en paralelo
                    val nowPlaying = nowPlayingDeferred.await()
                    val popular = popularDeferred.await()
                    val topRated = topRatedDeferred.await()
                    val upcoming = upcomingDeferred.await()

                    state = state.copy(
                        nowPlayingMovies = nowPlaying,
                        popularMovies = popular,
                        topRatedMovies = topRated,
                        upcomingMovies = upcoming,
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