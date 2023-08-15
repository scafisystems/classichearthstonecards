package com.scafisystems.classichearthstonecards.presenter.screen

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.scafisystems.classichearthstonecards.R
import com.scafisystems.classichearthstonecards.domain.entity.Card
import com.scafisystems.classichearthstonecards.presenter.components.DetailsCard
import com.scafisystems.classichearthstonecards.presenter.helper.MockData

@Composable
fun DetailsCardScreen(
    modifier: Modifier = Modifier,
    card: Card,
    navController: NavController,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                title = { Text(stringResource(R.string.details_title) + " ${card.name}") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }

                }
            )
        }
    ) {
        DetailsCard(modifier = modifier, card = card)
    }
}

@Preview(name = "DetailsCardScreen")
@Composable
private fun PreviewDetailsCardScreen() {
    DetailsCardScreen(card = MockData.card2, navController = rememberNavController())
}