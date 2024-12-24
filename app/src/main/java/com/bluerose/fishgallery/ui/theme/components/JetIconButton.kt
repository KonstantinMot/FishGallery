package com.bluerose.fishgallery.ui.theme.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bluerose.fishgallery.ui.theme.FishGalleryTheme
import com.microsoft.fluent.mobile.icons.R
import dashedBorder


@Composable
fun JetIconButton(
    vectorDrawableId: Int,

    shape: CornerBasedShape,
    contentPadding: PaddingValues,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {


    Box(
        modifier = modifier
            .dashedBorder(2.dp, MaterialTheme.colorScheme.onPrimary, shape, on = 10.dp, off = 8.dp)
            .clip(shape)
            .clickable(onClick=onClick)
            .padding(contentPadding),

        contentAlignment = Alignment.Center

    ) {
        Icon(
            painter = painterResource(vectorDrawableId),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.size(24.dp)
        )

    }
}


@Preview(showBackground = true)
@Composable
fun JetIconButtonPreview() {
    FishGalleryTheme {
        JetIconButton(
            R.drawable.ic_fluent_chevron_left_16_filled,

            MaterialTheme.shapes.small,
            contentPadding = PaddingValues(
                12.dp
            ),
            onClick = {}
        )

    }
}

