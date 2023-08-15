package com.scafisystems.classichearthstonecards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.scafisystems.classichearthstonecards.presenter.navigation.NavigationComponent
import com.scafisystems.classichearthstonecards.presenter.viewmodel.ClassicCardsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivityCompose : ComponentActivity() {

    private val viewModel: ClassicCardsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationComponent(
                navController = rememberNavController(),
                viewModel = viewModel
            )
        }
    }
}