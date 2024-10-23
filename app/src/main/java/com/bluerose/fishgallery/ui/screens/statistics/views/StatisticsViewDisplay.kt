package com.bluerose.fishgallery.ui.screens.statistics.views
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bluerose.fishgallery.ui.theme.FishGalleryTheme
import com.bluerose.fishgallery.ui.theme.components.JetRoundIcon
import com.microsoft.fluent.mobile.icons.R

@SuppressLint("SuspiciousIndentation")
@Composable
fun StatisticsViewDisplay() {
    val scrollState = rememberScrollState()


        Column(

            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary)


                .padding(start = 24.dp, end = 24.dp, top = 32.dp, bottom = 16.dp)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(24.dp)

        ) {
            Text(
                text = buildAnnotatedString {
                    append("Компания")
                    withStyle(style = SpanStyle(fontSize = 32.sp)) {
                        append("“Blue Rose”")
                    }
                },
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 24.sp),
                modifier = Modifier.padding(bottom = 8.dp)


            )

            StatisticsCard(
                "Наш улов",
                "~ 108 000 000 тонн",
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 128.dp),
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 32.dp, bottomEnd = 16.dp)
            )
            StatisticsCard(
                "Наша прибыль",
                "> 5 400 000 кредитов",
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 128.dp),
                shape = RoundedCornerShape(
                    topStart = 16.dp,
                    bottomStart = 32.dp,
                    bottomEnd = 16.dp
                )
            )
            StatisticsCard(
                "Наши пратнеры",
                "1 500+ партнеров",
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 160.dp),
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 48.dp, bottomEnd = 16.dp)
            )
Spacer(Modifier.size(42.dp))
            Row(
            modifier = Modifier
                .fillMaxWidth()

            ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = "С заботой, Blue Rose",
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 24.sp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            JetRoundIcon(
                vectorDrawableId = R.drawable.ic_fluent_food_fish_24_filled,
                modifier = Modifier.size(64.dp)
            )
        }
    }


}
@Preview
@Composable
fun StatisticsViewDisplayPreview() {
    FishGalleryTheme { StatisticsViewDisplay() }
}