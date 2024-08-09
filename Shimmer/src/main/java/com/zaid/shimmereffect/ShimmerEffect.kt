package com.zaid.shimmereffect

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize

enum class ShimmerDirection {
    LEFT_TO_RIGHT, RIGHT_TO_LEFT, TOP_TO_BOTTOM, BOTTOM_TO_TOP
}

fun Modifier.shimmerEffect(
    colors: List<Color> = listOf(Color(0xFFDFDBDB), Color(0xFFFFFFFF), Color(0xFFDFDBDB)),
    durationMillis: Int = 1000,
    direction: ShimmerDirection = ShimmerDirection.LEFT_TO_RIGHT
): Modifier = composed {

    var size by remember { mutableStateOf(IntSize.Zero) }
    val transition = rememberInfiniteTransition(label = "")

    val startOffset by transition.animateFloat(
        initialValue = -2 * maxOf(size.width, size.height).toFloat(),
        targetValue = 2 * maxOf(size.width, size.height).toFloat(),
        animationSpec = infiniteRepeatable(animation = tween(durationMillis)),
        label = ""
    )

    val (start, end) = when (direction) {
        ShimmerDirection.LEFT_TO_RIGHT -> Offset(
            startOffset,
            0f
        ) to Offset(startOffset + size.width.toFloat(), size.height.toFloat())

        ShimmerDirection.RIGHT_TO_LEFT -> Offset(
            -startOffset,
            0f
        ) to Offset(-startOffset + size.width.toFloat(), size.height.toFloat())

        ShimmerDirection.TOP_TO_BOTTOM -> Offset(0f, startOffset) to Offset(
            size.width.toFloat(),
            startOffset + size.height.toFloat()
        )

        ShimmerDirection.BOTTOM_TO_TOP -> Offset(0f, -startOffset) to Offset(
            size.width.toFloat(),
            -startOffset + size.height.toFloat()
        )
    }

    background(
        brush = Brush.linearGradient(
            colors = colors,
            start = start,
            end = end
        )
    ).onGloballyPositioned { size = it.size }
}

