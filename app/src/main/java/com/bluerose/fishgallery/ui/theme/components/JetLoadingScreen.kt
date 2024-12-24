package com.bluerose.fishgallery.ui.theme.components


import androidx.compose.foundation.layout.Box


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bluerose.fishgallery.ui.theme.FishGalleryTheme

@Composable
fun JetLoadingScreen(modifier: Modifier = Modifier) {
    Box(Modifier.fillMaxSize()) {

        CircularProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .align(Alignment.TopStart)
        )
    }

}
@Preview
@Composable
private fun JetLoadingScreenPreview() {
    FishGalleryTheme { JetLoadingScreen() }
}