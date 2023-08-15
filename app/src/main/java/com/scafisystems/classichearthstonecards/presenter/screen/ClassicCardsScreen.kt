package com.scafisystems.classichearthstonecards.presenter.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.scafisystems.classichearthstonecards.R
import com.scafisystems.classichearthstonecards.domain.entity.Card
import com.scafisystems.classichearthstonecards.presenter.components.CardItemList
import com.scafisystems.classichearthstonecards.presenter.helper.MockData
import com.scafisystems.classichearthstonecards.presenter.navigation.NavRouteName
import com.scafisystems.classichearthstonecards.presenter.ui.theme.Purple200

@Composable
fun ClassicCardsScreen(
    cards: List<Card>,
    navController: NavController,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                title = { Text(stringResource(R.string.classic_title)) }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .background(Purple200)
                .fillMaxWidth()
                .padding(4.dp),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(cards) { card ->
                CardItemList(card = card) {
                    val cardId = card.cardId
                    navController.navigate("${NavRouteName.DETAILS.name}/$cardId") {
                        popUpTo("classicCards")
                    }
                }
            }
        }
    }
}

@Preview(name = "ClassicCardsScreen")
@Composable
private fun PreviewClassicCardsScreen() {
    ClassicCardsScreen(cards = MockData.listOfCards, navController = rememberNavController())
}
