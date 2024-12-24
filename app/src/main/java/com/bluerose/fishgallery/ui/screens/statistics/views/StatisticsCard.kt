package com.bluerose.fishgallery.ui.screens.statistics.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bluerose.fishgallery.ui.theme.FishGalleryTheme
import dashedBorder

@Composable
fun StatisticsCard(
    label: String,
    text: String,
    onClick: (() -> Unit)? = null,
    shape: RoundedCornerShape,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.surface, shape)
            .dashedBorder(3.dp, Color(0xff000000).copy(0.1f), shape, on = 10.dp, off = 8.dp)
            .clip(shape)
            .let { if (onClick != null) it.clickable(onClick = onClick) else it }
            .padding(top = 24.dp, start = 20.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp)


    )
    {
        Text(
            text = label,
            color = Color(0xFFACACAC),
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp)
        )
        Text(
            text = buildAnnotatedString {
                text.forEach { char ->
                    if (char.isLetter()) {
                        withStyle(
                            style = SpanStyle(
                                color = MaterialTheme.colorScheme.onSurface,
                                fontSize = 24.sp

                            )
                        ) {
                            append(char)

                        }
                    } else {
                        append(char)
                    }


                }
            },
            color = MaterialTheme.colorScheme.onSecondary,
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 32.sp)
        )


    }
}


@Preview
@Composable
fun StatisticsCardPreview() {
    FishGalleryTheme {
        Column(verticalArrangement = Arrangement.spacedBy(21.dp)) {
            StatisticsCard(
                "Наш улов",
                "~ 108 000 000 тонн",
                modifier = Modifier.size(366.dp, 128.dp),
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 32.dp, bottomEnd = 16.dp)
            )
            StatisticsCard(
                "Наша прибыль",
                "> 5 400 000 кредитов",
                modifier = Modifier.size(
                    366.dp,
                    128.dp
                ),
                shape = RoundedCornerShape(
                    topStart = 16.dp,
                    bottomStart = 32.dp,
                    bottomEnd = 16.dp
                )
            )
            StatisticsCard(
                "Наши пратнеры",
                "1 500+ партнеров",
                modifier = Modifier.size(366.dp, 160.dp),
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 48.dp, bottomEnd = 16.dp)
            )
        }
    }
}

