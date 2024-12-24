package com.bluerose.fishgallery.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bluerose.fishgallery.ui.theme.FishGalleryTheme
import com.microsoft.fluent.mobile.icons.R

@Composable
fun JetRoundIcon(
    vectorDrawableId: Int,
    modifier: Modifier = Modifier
) {
    Box(
       modifier =  modifier
           . size(64.dp)
            .background(MaterialTheme.colorScheme.primary, CircleShape)
            .border(3.dp, MaterialTheme.colorScheme.onPrimary, CircleShape)

            ,

        contentAlignment = Alignment.Center

    ) {
      Icon(
            painter = painterResource(id=vectorDrawableId),
            contentDescription = null,
          tint=MaterialTheme.colorScheme.onPrimary,
          modifier = Modifier.fillMaxSize()
              . padding(16.dp)






        )


    }
}

@Preview(showBackground = true)
@Composable
fun JetRoundIconPreview() {
    FishGalleryTheme {
        JetRoundIcon(
            vectorDrawableId = R.drawable.ic_fluent_food_fish_24_filled,
            modifier = Modifier.clip(CircleShape)
                .clickable {  }



        )
    }
}













