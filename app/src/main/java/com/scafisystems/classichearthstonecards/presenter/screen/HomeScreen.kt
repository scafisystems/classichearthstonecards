package com.scafisystems.classichearthstonecards.presenter.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.scafisystems.classichearthstonecards.presenter.components.CircularProgressBar
import com.scafisystems.classichearthstonecards.presenter.components.ErrorText
import com.scafisystems.classichearthstonecards.presenter.model.CardState
import com.scafisystems.classichearthstonecards.presenter.navigation.NavRouteName
import com.scafisystems.classichearthstonecards.presenter.ui.theme.ClassicHearthStoneCardsTheme
import com.scafisystems.classichearthstonecards.presenter.viewmodel.ClassicCardsViewModel

@Composable
fun HomeScreen(viewModel: ClassicCardsViewModel, navController: NavController) {
    ClassicHearthStoneCardsTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val cardState by viewModel.cardState.observeAsState()

            when (cardState) {
                CardState.IS_LOADING -> CircularProgressBar()
                CardState.FAIL -> ErrorText()
                CardState.LOAD -> navController.navigate(NavRouteName.CLASSIC_CARDS.name)
                else -> {}
            }

        }
    }
}