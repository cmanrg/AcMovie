package dev.cmanrg.acmovie.core.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Este modelo representa la respuesta completa del servidor
 * Tiene paginacion (page, total_pages, total_results)
 * y un campo result (renombrado a movies) con la lista de peliculas crudas
 */
@JsonClass(generateAdapter = true)
data class MoviesResponse(
    val page: Int, // Número de página actual
    @Json(name = "results")
    val movies: List<MovieDto>, // Lista de películas en esta página
    @Json(name = "total_pages")
    val totalPages: Int, // Número total de páginas
    @Json(name = "total_results")
    val totalResults: Int // Número total de resultados

)
