package dev.cmanrg.acmovie.detail.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.cmanrg.acmovie.R
import dev.cmanrg.acmovie.detail.domain.model.MovieDetails
import dev.cmanrg.acmovie.ui.components.PosterCard

@Composable
fun MediaDetailsContent(
    modifier: Modifier = Modifier,
    releaseDate: String,
    director: String,
    writers: String,
    movieDetails: MovieDetails

) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)
    ) {
        Row {

        }

        //  Information and poster
        Row(
            modifier = Modifier,

        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Row {
                    TextTitleDetail(title = stringResource(R.string.status))
                    SpacerWidth()
                    TextContentDetail(contentText = movieDetails.status)
                }
                SpacerHeight()
                Row {
                    TextTitleDetail(title = stringResource(R.string.release_date))
                    SpacerWidth()
                    TextContentDetail(contentText = releaseDate)
                }
                SpacerHeight()
                Row {
                    TextTitleDetail(title = stringResource(R.string.director))
                    SpacerWidth()
                    TextContentDetail(contentText = director)
                }
                SpacerHeight()
                Row {
                    TextTitleDetail(title = stringResource(R.string.writers))
                    SpacerWidth()
                    TextContentDetail(contentText = writers)
                }
            }

            PosterCard(
                image = movieDetails.posterPath ?: "",
                onClick = {}
            )
        }
    }

}

@Composable
fun SpacerWidth(
    modifier: Modifier = Modifier
) {
    Spacer(modifier = modifier.width(3.dp))
}

@Composable
fun SpacerHeight(
    modifier: Modifier = Modifier
) {
    Spacer(modifier = modifier.height(20.dp))
}

@Composable
fun TextTitleDetail(
    modifier: Modifier = Modifier,
    title: String,
) {
    Text(
        title,
        style = MaterialTheme.typography.labelLarge.copy(
            fontWeight = FontWeight.Medium,
            fontSize = MaterialTheme.typography.labelMedium.fontSize,
            color = MaterialTheme.colorScheme.onBackground,
        ),
        modifier = modifier,
    )
}

@Composable
fun TextContentDetail(
    modifier: Modifier = Modifier,
    contentText: String,
) {
    Text(

        contentText,
        style = MaterialTheme.typography.labelLarge.copy(
            fontWeight = FontWeight.Black,
            fontSize = MaterialTheme.typography.labelMedium.fontSize,
            color = MaterialTheme.colorScheme.onBackground,
        ),
        modifier = modifier,
    )
}
