package com.bluerose.fishgallery.ui.theme.components
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.bluerose.fishgallery.ui.theme.FishGalleryTheme


@Composable
fun JetRoundImage(
    imagePath: String,
    modifier: Modifier
) {
    Box(modifier = modifier
        .fillMaxWidth()
        .heightIn(max = 136.dp)
        .clip(MaterialTheme.shapes.medium)
        .border(BorderStroke(3.dp, MaterialTheme.colorScheme.surface), MaterialTheme.shapes.medium)){
    AsyncImage(
        model = imagePath,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()







    )
}}


@Preview(showBackground = true)
@Composable
fun JetRoundImagePreview() {
    FishGalleryTheme {  JetRoundImage(
        imagePath = "file:///android_asset/Fish1.jpg",
        modifier = Modifier
    )
}}
