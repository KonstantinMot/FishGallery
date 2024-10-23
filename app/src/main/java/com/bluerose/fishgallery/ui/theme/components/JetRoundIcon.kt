package com.bluerose.fishgallery.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.microsoft.fluent.mobile.icons.R
import com.bluerose.fishgallery.ui.theme.FishGalleryTheme

@Composable
fun JetRoundIcon(
    vectorDrawableId: Int,
    modifier: Modifier = Modifier
) {
    Box(
       modifier =  modifier
            .background(MaterialTheme.colorScheme.primary, CircleShape)
            .border(3.dp, MaterialTheme.colorScheme.onPrimary, CircleShape)
            .size(64.dp),
        contentAlignment = Alignment.Center

    ) {
      Icon(
            painter = painterResource(id=vectorDrawableId),
            contentDescription = null,
            modifier = Modifier
                .size(32.dp),
           tint=MaterialTheme.colorScheme.onPrimary


        )


    }
}

@Preview(showBackground = true)
@Composable
fun JetRoundIconPreview() {
    FishGalleryTheme {
        JetRoundIcon(
            vectorDrawableId = R.drawable.ic_fluent_food_fish_24_filled,
            modifier = Modifier.size(64.dp)


        )
    }
}













