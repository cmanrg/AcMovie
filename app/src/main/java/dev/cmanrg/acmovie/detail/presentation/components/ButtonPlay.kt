package dev.cmanrg.acmovie.detail.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ButtonPlay(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
//Color(0xFF0F1511)
    Box(
        modifier = modifier
            .wrapContentSize()
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.6f))
            .clickable{
                onClick()
            },
        contentAlignment = Alignment.Center,

        ) {

        Icon(
            modifier = Modifier
                .padding(8.dp)
                .size(35.dp),
            imageVector = Icons.Rounded.PlayArrow,
            contentDescription = null,
            tint = Color(0xFF0F1511).copy(alpha = 0.7f)
        )

    }

}

@Preview(showBackground = true)
@Composable
fun ButtonPlayPreview() {
    ButtonPlay(onClick = {})
}