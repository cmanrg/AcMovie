package dev.cmanrg.acmovie.detail.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun BottomGradient(
    modifier: Modifier = Modifier,
    height: Dp,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent, Color(0xFF0F1511)
                    )
                )
            )
    )
}

@Preview(showSystemUi = true)
@Composable
fun BottomGradientPreview() {
    BottomGradient(
        height = 100.dp
    )

}