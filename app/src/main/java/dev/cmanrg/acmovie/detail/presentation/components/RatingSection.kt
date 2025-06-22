package dev.cmanrg.acmovie.detail.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.cmanrg.acmovie.R

@Composable
fun RatingSection(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 15.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically

    ) {
        // Total votos
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            TextMedium(
                text = "7.6/10"
            )

            TextSmall(text = stringResource(R.string.imdb))

        }

        // TMDb Rating
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TextMedium(
                text = "91%"
            )
            TextSmall(text = stringResource(R.string.tmdb))
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TextMedium(
                text = "30,000"
            )
            TextSmall(text = stringResource(R.string.vote))
        }


    }
}

@Composable()
fun TextSmall(
    modifier: Modifier = Modifier,
    text: String,
) {
    Text(
        text,
        style = MaterialTheme.typography.bodyMedium.copy(
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onBackground
        ),
        modifier = modifier
    )
}

@Composable()
fun TextMedium(
    modifier: Modifier = Modifier,
    text: String,
) {
    Text(
        text,
        style = MaterialTheme.typography.headlineSmall.copy(
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            color = MaterialTheme.colorScheme.onBackground
        ),
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun RatingSectionPreview() {
    RatingSection()
}