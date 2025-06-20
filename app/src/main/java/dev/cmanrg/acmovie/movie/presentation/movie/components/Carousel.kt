package dev.cmanrg.acmovie.movie.presentation.movie.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.cmanrg.acmovie.core.presentation.components.AppImage
import dev.cmanrg.acmovie.movie.domain.models.Movie
import kotlinx.coroutines.delay

@Composable
fun Carousel(
    movies: List<Movie>,
    modifier: Modifier = Modifier,
    onMovieClick: () -> Unit
) {
    val pagerState = rememberPagerState(
        pageCount = { movies.size }, // Total paginas
        initialPage = 0
    )

    if (movies.isNotEmpty()) {
        LaunchedEffect(pagerState) {
            while (true) {
                delay(5000)
                val nextPage = (pagerState.currentPage + 1) % movies.size
                pagerState.animateScrollToPage(nextPage)
            }
        }
    }

    Box(
        modifier = modifier.fillMaxHeight(fraction = 0.6f)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize(),
            userScrollEnabled = false
        ) { page ->
            val movie = movies[page]

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(bounded = true),
                        onClick = { onMovieClick() }
                    )
            ) {

                // Fondo con imagen
                AppImage(
                    imageUrl = movie.backdropPath,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )

                // Degradado inferior
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .height(250.dp)
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent, Color(0xFF0F1511)
                                )
                            )
                        )
                )

                // Texto encima del degradado
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                ) {
                    Text(
                        movie.originalTitle,
                        style = MaterialTheme.typography.titleLarge.copy(
                            color = Color(0xFFDEE4DE),
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    )

                    Spacer(modifier = Modifier.height(7.dp))

                    Text(
                        movie.overview,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = Color(0xFFDEE3E5),
                            fontSize = 12.sp,
                            lineHeight = 15.sp,
                            textAlign = TextAlign.Left
                        ),
                        maxLines = 5
                    )

                    Spacer(modifier = Modifier.height(7.dp))

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        BoxProperties(text = "Votos 🗳️: ${movie.voteCount}")
                        Spacer(modifier = Modifier.width(8.dp))
                        BoxProperties(text = "Calificación ⭐️: ${movie.voteAverage}")
                        Spacer(modifier = Modifier.width(8.dp))
                        BoxProperties(text = "Popularidad: ${getPopularityLabel(movie.popularity ?: 0.0)}")
                    }
                }
            }
        }

    }
}

fun getPopularityLabel(value: Double): String {

    return when {
        value > 800 -> "🔥 Muy popular"
        value > 500 -> "🔥 Popular"
        value > 100 -> "👍 Algo popular"
        else -> "👀 Poco conocida"
    }
}

@Composable
fun BoxProperties(
    modifier: Modifier = Modifier,
    text: String,
) {

    Box(
        modifier = modifier
            .wrapContentSize()
            .clip(RoundedCornerShape(10.dp)) // 👈 primero el clip
            .background(Color(0x394D4C4C).copy(alpha = 0.4f)) // 👈 luego el fondo ya respetando el clip
            .padding(start = 5.dp, end = 5.dp, top = 2.dp, bottom = 2.dp)
    ) {

        Text(
            text, style = MaterialTheme.typography.titleMedium.copy(
                color = Color(0xFFDEE4DE), fontWeight = FontWeight.Bold, fontSize = 10.sp
            )
        )
    }

}

@Preview(name = "BoxProperties", showBackground = true)
@Composable
fun BoxPropertiesPreview() {
    BoxProperties(text = "2025")
}

