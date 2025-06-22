package dev.cmanrg.acmovie.detail.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FamilyRestroom
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.cmanrg.acmovie.R

@Composable
fun CoverSummary(
    modifier: Modifier = Modifier,
    title: String,
    tagline: String?,
    runtime: String,
    adult: Boolean,
    genres: List<String>,
) {

    Column(
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 20.dp),
    ) {

        Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                if (!tagline.isNullOrEmpty()) {
                    Text(
                        text = tagline,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Medium
                        )
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(50.dp)
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            if (adult) {
                                Icon(
                                    painter = painterResource(R.drawable.adult),
                                    contentDescription = stringResource(R.string.adults_only)
                                )
                            } else {
                                Icon(
                                    imageVector = Icons.Rounded.FamilyRestroom,
                                    contentDescription = stringResource(R.string.suitable_for_everyone)

                                )
                            }

                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = if (adult) stringResource(R.string.adults_only) else stringResource(
                                    R.string.suitable_for_everyone
                                ),
                                style = MaterialTheme.typography.labelMedium
                            )
                        }
                    }


                    Text(
                        text = runtime,
                        style = MaterialTheme.typography.labelMedium
                    )


                }

            }

            // Este botón mantiene su tamaño fijo
            ButtonPlay(
                modifier = Modifier.align(Alignment.Top),
                onClick = {}
            )
        }

        Spacer(modifier = Modifier.height(10.dp))


        BoxProperties(
            genres = genres
        )
    }


}

@Composable
fun BoxProperties(
    modifier: Modifier = Modifier,
    genres: List<String>,
) {

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {

        itemsIndexed(genres) { index, genre ->
            Box(
                modifier = modifier
                    .wrapContentSize()
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color(0x394D4C4C).copy(alpha = 0.4f))
                    .padding(start = 5.dp, end = 5.dp, top = 2.dp, bottom = 2.dp)
            ) {

                Text(
                    genre, style = MaterialTheme.typography.titleMedium.copy(
                        color = Color(0xFFDEE4DE), fontWeight = FontWeight.Bold, fontSize = 10.sp
                    )
                )
            }
        }

    }

}

@Preview(name = "BoxProperties", showBackground = true)
@Composable
fun BoxPropertiesPreview() {
    BoxProperties(
        genres = listOf("Action", "Adventure", "Science Fiction"),
    )
}

@Preview(showBackground = true)
@Composable
fun CoverSummaryPreview() {
    CoverSummary(
        title = "Avatar",
        tagline = "Enter the world of Pandora.",
        runtime = "1h 44min",
        adult = true,
        genres = listOf(
            "Action",
            "Adventure",
            "Science Fiction",
            "Science Fiction",
            "Science Fiction",
            "Science Fiction",
            "Science Fiction"
        ),
    )
}