@file:JvmName("DetailsCardScreenKt")

package com.scafisystems.classichearthstonecards.presenter.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.scafisystems.classichearthstonecards.R
import com.scafisystems.classichearthstonecards.domain.entity.Card
import com.scafisystems.classichearthstonecards.presenter.helper.MockData
import com.scafisystems.classichearthstonecards.presenter.ui.theme.Purple200

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailsCard(
    modifier: Modifier = Modifier,
    card: Card
) {

    val context = LocalContext.current
    val emptyText = context.getString(R.string.txt_empty)

    Column(
        modifier
            .background(Purple200)
            .verticalScroll(rememberScrollState()),
    ) {
        GlideImage(
            modifier = modifier
                .fillMaxWidth()
                .height(300.dp),
            model = card.img,
            contentDescription = null
        )
        CardText(
            title = context.getString(R.string.txt_name),
            description = card.name ?: emptyText
        )
        CardText(
            title = context.getString(R.string.txt_description),
            description = card.flavor ?: emptyText
        )
        CardText(
            title = context.getString(R.string.txt_desc2),
            description = card.text ?: emptyText
        )
        CardText(
            title = context.getString(R.string.txt_set),
            description = card.cardSet ?: emptyText
        )
        CardText(
            title = context.getString(R.string.txt_type),
            description = card.type ?: emptyText
        )
        CardText(
            title = context.getString(R.string.txt_faction),
            description = card.faction ?: emptyText
        )
        CardText(
            title = context.getString(R.string.txt_rarity),
            description = card.rarity ?: emptyText
        )
        val attack = if (card.attack != null) card.attack.toString() else emptyText
        CardText(
            title = context.getString(R.string.txt_attack),
            description = attack
        )
        val cost = if (card.cost != null) card.cost.toString() else emptyText
        CardText(
            title = context.getString(R.string.txt_cost),
            description = cost
        )
        val health = if (card.health != null) card.health.toString() else emptyText
        CardText(
            title = context.getString(R.string.txt_health),
            description = health
        )
    }
}

@Preview(name = "DetailsCard")
@Composable
private fun PreviewDetailsCard() {
    DetailsCard(modifier = Modifier, card = MockData.card1)
}