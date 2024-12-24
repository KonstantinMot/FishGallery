package com.bluerose.fishgallery.ui.theme.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.bluerose.fishgallery.ui.theme.FishGalleryTheme

@Composable
fun JetDialog(title: String, body: String, buttonText: String, onClose: () -> Unit) {
    Dialog(onDismissRequest = onClose,
        ) {
        DialogContent(title, body, buttonText, onClose)
    }

}

@Composable
private fun DialogContent(title: String, body: String, buttonText: String, onClose: () -> Unit) {
    Column(
        Modifier
            .fillMaxWidth()
            .clip(
                shape = RoundedCornerShape(
                    topStart = 64.dp,
                    topEnd = 64.dp,
                    bottomStart = 32.dp,
                    bottomEnd = 32.dp
                )
            )
            .background(
                MaterialTheme.colorScheme.secondary,


                ),


        horizontalAlignment = Alignment.CenterHorizontally

    )
    {


        Column(Modifier.width(IntrinsicSize.Max)){
        Text(
            text = title,
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.titleLarge.copy(fontSize = 16.sp),
            modifier = Modifier.padding(top = 16.dp)
        )
        HorizontalDivider(Modifier.fillMaxWidth(),
            thickness = 1.dp, color = MaterialTheme.colorScheme.onSurface
            )}
        Text(
            text = body,
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 14.sp, lineHeight = 16.sp),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 9.dp, bottom = 20.dp)

        )
        Box(
            Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.onPrimary),
            contentAlignment = Alignment.Center
        ) {
            TextButton(
                onClick = onClose,


                ) {
                Text(
                    text = buttonText,
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 16.sp)
                )
            }
        }
    }

}



@Preview
@Composable
private fun JetDialogPreview() {
    FishGalleryTheme {
        JetDialog(
            "Наши контакты",

            "E-mail: blue-rose@our.galaxy \nАдресат: Джонни Сильверхэд",
            "ОК",
            onClose = {}
        )
    }
}