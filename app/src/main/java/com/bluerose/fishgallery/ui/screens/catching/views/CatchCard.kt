package com.bluerose.fishgallery.ui.screens.catching.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bluerose.fishgallery.ui.theme.FishGalleryTheme
import com.bluerose.fishgallery.ui.theme.components.JetRoundImage

@Composable
fun CatchCard(label: String, text: String, imagePath: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        JetRoundImage(imagePath, modifier = modifier)
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = label,
                Modifier.padding(start = 10.dp),
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),

            )
            Text(
                text = text,
                Modifier.padding(end = 10.dp),
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 16.sp)
            )
        }
    }
}

@Preview()
@Composable
fun CatchCardPreview() {
    FishGalleryTheme {
        CatchCard(
            "Призрачный дельфин",
            "50 000 000 тонн",
            "file:///android_asset/Fish1.jpg",
            modifier = Modifier.fillMaxWidth()
        )
    }
}