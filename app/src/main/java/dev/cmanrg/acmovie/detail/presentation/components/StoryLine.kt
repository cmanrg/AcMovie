package dev.cmanrg.acmovie.detail.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.cmanrg.acmovie.R
import dev.cmanrg.acmovie.detail.domain.model.MovieDetails

@Composable
fun StoryLine(
    modifier: Modifier = Modifier,
    movieDetails: MovieDetails
) {


    Column (
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp)
    ){
        Text(text = stringResource(R.string.story_line),
            style = MaterialTheme.typography.headlineMedium.copy(
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = movieDetails.overview,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Medium,
                lineHeight = 18.sp,
                letterSpacing = 0.5.sp,
            )
        )
    }


}
