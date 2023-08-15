package com.scafisystems.classichearthstonecards.presenter.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.scafisystems.classichearthstonecards.presenter.ui.theme.BackgroundText

@Composable
fun CardText(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
) {
    Row(
        modifier
            .padding(4.dp)
            .background(
                shape = RoundedCornerShape(10.dp), color = BackgroundText
            )
            .padding(4.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                fontStyle = FontStyle.Italic
            ),
        )
        Spacer(modifier = modifier.padding(4.dp))
        Text(
            text = description,
            style = TextStyle(
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic
            ),
        )
    }
}

@Preview(name = "CardText")
@Composable
private fun PreviewCardText() {
    CardText(title = "Test", description = "test")
}