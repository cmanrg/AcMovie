package dev.cmanrg.acmovie.core.util

object FormatRuntime {
    fun formatRuntime(runtime: Int): String {
        val hours = runtime / 60
        val minutes = runtime % 60
        return "${hours}h ${minutes}min"
    }
}