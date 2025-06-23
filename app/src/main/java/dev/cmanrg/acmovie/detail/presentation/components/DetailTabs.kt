package dev.cmanrg.acmovie.detail.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import dev.cmanrg.acmovie.R
import dev.cmanrg.acmovie.detail.domain.model.MovieResponse

@Composable
fun DetailTabs(
    movieSimilar: List<MovieResponse>,
    movieRecommended: List<MovieResponse>,
    modifier: Modifier = Modifier,
    //movieDetails: MovieDetails
) {


    val tabs = listOf(
        stringResource(R.string.about),
        stringResource(R.string.more_like_this),
        stringResource(R.string.comments)
    )
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxWidth()

    ) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.Transparent, // Fondo transparente
            contentColor = MaterialTheme.colorScheme.onSurface, // Texto/icono que contraste

        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = {
                        Text(
                            title, style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 14.sp,
                                letterSpacing = 0.1.sp,
                                fontWeight = FontWeight.Medium,
                                color = if (selectedTabIndex == index)
                                    MaterialTheme.colorScheme.onPrimaryContainer
                                else
                                    MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        )
                    }
                )
            }
        }
        when (selectedTabIndex) {
            0 -> Text(text = "About")
            1 -> RecommendedAndSimilarContent(
                movieSimilar = movieSimilar,
                movieRecommended = movieRecommended,
                onClickListener = {}
            )

            2 -> Text(text = "Comments")
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun DetailScreenPreview() {
    //DetailTabs()
}