package com.bluerose.fishgallery.ui.screens.catch.views


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bluerose.fishgallery.data.local.entity.FishCatchDetails
import com.bluerose.fishgallery.models.CatchEvent
import com.bluerose.fishgallery.models.CatchViewState
import com.bluerose.fishgallery.ui.theme.FishGalleryTheme
import com.bluerose.fishgallery.ui.theme.components.JetIconButton
import com.microsoft.fluent.mobile.icons.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatchViewDisplay(state: CatchViewState.Display, dispatch: (CatchEvent) -> Unit) {
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
                    MaterialTheme.shapes.small,
                    contentPadding = PaddingValues(12.dp),
                    onClick = { dispatch.invoke(CatchEvent.CloseScreen) }
                )

                Text(
                    text = stringResource(com.bluerose.fishgallery.R.string.our_catch_title),
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 24.sp),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }

            state.fishCatchGallery.forEach { fishCatch ->
                CatchCard(
                    fishCatch.fishName,
                    stringResource(com.bluerose.fishgallery.R.string.our_catch_value).format(
                        fishCatch.fishCatch
                    ).removePrefix("~"),
                    fishCatch.imagePath,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }




@Preview(locale = "eng")
@Composable
fun CatchViewDisplayPreview() {
    val sampleState = CatchViewState.Display(
        fishCatchGallery = listOf(
            FishCatchDetails(
                "Призрачный дельфин",
                50000000,
                "file:///android_asset/Fish1.jpg"
            ),
            FishCatchDetails("Алмазный усач", 40000000, "file:///android_asset/Fish2.jpg"),
            FishCatchDetails(
                "Шестиперая акула",
                10000000,
                "file:///android_asset/Fish3.jpg"
            )
        )
    )
    val mockDispatch: (CatchEvent) -> Unit = {}

    FishGalleryTheme {
        CatchViewDisplay(sampleState, dispatch = mockDispatch)
    }

}