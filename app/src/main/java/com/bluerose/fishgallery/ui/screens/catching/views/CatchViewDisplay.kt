package com.bluerose.fishgallery.ui.screens.catching.views
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bluerose.fishgallery.ui.theme.FishGalleryTheme
import com.bluerose.fishgallery.ui.theme.components.ContentPadding
import com.bluerose.fishgallery.ui.theme.components.JetIconButton
import com.microsoft.fluent.mobile.icons.R

@Composable
fun CatchViewDisplay() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .padding(start = 24.dp, top = 24.dp, end = 24.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Box(
            Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterStart

        ) {
            JetIconButton(
                R.drawable.ic_fluent_chevron_left_16_filled,
                Modifier.size(48.dp),
                MaterialTheme.shapes.small,
                ContentPadding(
                    12.dp
                )
            )
            Text(
                text = "Наш улов",
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 24.sp),
                modifier = Modifier

                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
        CatchCard(
            "Призрачный дельфин",
            "50 000 000 тонн",
            "file:///android_asset/Fish1.jpg",
            modifier = Modifier.fillMaxWidth()
        )
        CatchCard(
            "Алмазный усач",
            "48 000 000 тонн",
            "file:///android_asset/Fish2.jpg",
            modifier = Modifier.fillMaxWidth()
        )
        CatchCard(
            "Шестиперая акула",
            "10 000 000 тонн",
            "file:///android_asset/Fish3.jpg",
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun CatchViewDisplayPreview() {
    FishGalleryTheme { CatchViewDisplay() }
}