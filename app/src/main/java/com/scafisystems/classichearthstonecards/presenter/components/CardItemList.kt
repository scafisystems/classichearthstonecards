package com.scafisystems.classichearthstonecards.presenter.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.scafisystems.classichearthstonecards.R
import com.scafisystems.classichearthstonecards.domain.entity.Card
import com.scafisystems.classichearthstonecards.presenter.helper.MockData

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CardItemList(
    modifier: Modifier = Modifier,
    card: Card,
    onclick: (Card) -> Unit
) {
    val context = LocalContext.current

    Card(
        modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable {
                onclick(card)
            },
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
    ) {
        Row {
            GlideImage(
                modifier = modifier
                    .width(150.dp)
                    .height(150.dp),
                model = card.img,
                contentDescription = null
            )
            Column(
                modifier = modifier
                    .height(150.dp),
            ) {
                card.name?.let {
                    Text(
                        text = it,
                        modifier = modifier
                            .padding(4.dp)
                    )
                }
                Text(
                    text = context.getString(R.string.txt_desc),
                    modifier = modifier
                        .padding(4.dp)
                )
                card.flavor?.let {
                    Text(
                        text = it,
                        modifier = modifier
                            .padding(4.dp)
                    )
                }

            }
        }
    }
}

@Preview(name = "Card_item_list")
@Composable
private fun PreviewCard_item_list() {
    CardItemList(modifier = Modifier, card = MockData.card1) {

    }
}