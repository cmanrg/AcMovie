package dev.cmanrg.acmovie.core.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.cmanrg.acmovie.R

@Composable
fun PosterCard(
    modifier: Modifier = Modifier,
    image: String,
    onClick: () -> Unit = {}
) {

    Box(
        modifier = modifier
            .width(150.dp)
            .height(200.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(bounded = true),
                onClick = { onClick() }
            )
    ) {
        AppImage(
            imageUrl = image,
            contentDescription = stringResource(R.string.movie_upcoming)
        )
    }

}
