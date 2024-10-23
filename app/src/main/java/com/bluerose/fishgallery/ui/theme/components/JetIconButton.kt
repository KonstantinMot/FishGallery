package com.bluerose.fishgallery.ui.theme.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bluerose.fishgallery.ui.theme.FishGalleryTheme
import com.microsoft.fluent.mobile.icons.R
import dashedBorder

data class ContentPadding(val start: Dp, val top: Dp, val end: Dp, val bottom: Dp) {
    constructor(padding: Dp) : this(start = padding, top = padding, end = padding, bottom = padding)
    constructor(horizontal: Dp, vertical: Dp) : this(
        start = horizontal,
        top = vertical,
        end = horizontal,
        bottom = vertical
    )
}

@Composable
fun JetIconButton(
    vectorDrawableId: Int,
    modifier: Modifier,
    shape: CornerBasedShape,
    contentPadding: ContentPadding
) {


    Box(
        modifier = modifier
            .dashedBorder(2.dp, MaterialTheme.colorScheme.onPrimary, shape, on = 10.dp, off = 8.dp)
            .padding(
                start = contentPadding.start,
                top = contentPadding.top,
                end = contentPadding.end,
                bottom = contentPadding.bottom
            ),
        contentAlignment = Alignment.Center

    ) {
        Icon(
            painter = painterResource(vectorDrawableId),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.size(24.dp, 24.dp)

        )

    }
}


@Preview(showBackground = true)
@Composable
fun JetIconButtonPreview() {
    FishGalleryTheme {
        JetIconButton(
            R.drawable.ic_fluent_chevron_left_16_filled,
            Modifier.size(48.dp),
            MaterialTheme.shapes.small,
            ContentPadding(
                12.dp
            )
        )
    }
}

