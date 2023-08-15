package com.scafisystems.classichearthstonecards.presenter.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.scafisystems.classichearthstonecards.domain.entity.Card
import com.scafisystems.classichearthstonecards.presenter.screen.ClassicCardsScreen
import com.scafisystems.classichearthstonecards.presenter.screen.DetailsCardScreen
import com.scafisystems.classichearthstonecards.presenter.screen.HomeScreen
import com.scafisystems.classichearthstonecards.presenter.viewmodel.ClassicCardsViewModel

@Composable
fun NavigationComponent(
    navController: NavHostController,
    viewModel: ClassicCardsViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = NavRouteName.HOME.name
    ) {
        composable(NavRouteName.HOME.name) {
            HomeScreen(viewModel = viewModel, navController)
        }
        composable(NavRouteName.CLASSIC_CARDS.name) {
            ClassicCardsScreen(viewModel.listOfClassicCards.value!!, navController)
        }
        composable(
            "${NavRouteName.DETAILS.name}/{cardId}",
            arguments = listOf(navArgument("cardId") {
                type = NavType.StringType
            })
        ) { it ->
            val cardId = it.arguments?.getString("cardId")
            val predicate: (Card) -> Boolean = { it.cardId == cardId }
            val card = viewModel.listOfClassicCards.value?.find(predicate)
            card?.let { card -> DetailsCardScreen(card = card, navController = navController) }
        }
    }
}