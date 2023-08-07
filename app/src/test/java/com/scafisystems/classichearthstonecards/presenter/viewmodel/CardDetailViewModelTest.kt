package com.scafisystems.classichearthstonecards.presenter.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.scafisystems.classichearthstonecards.domain.datasource.CardDataSource
import com.scafisystems.classichearthstonecards.domain.usecase.GetSelectCardUseCase
import com.scafisystems.classichearthstonecards.helper.LiveDataHelper.getOrAwaitValue
import com.scafisystems.classichearthstonecards.helper.MockData
import com.scafisystems.classichearthstonecards.presenter.imageloader.ImageLoader
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import java.util.concurrent.Executors

class CardDetailViewModelTest {
    @Rule
    @JvmField
    var rule: TestRule = InstantTaskExecutorRule()

    private val mainThreadSurrogate = Executors.newSingleThreadExecutor().asCoroutineDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

    @Test
    fun shouldLoadClassicCards() {
        val cardDataSource = mockk<CardDataSource>()
        coEvery {
            cardDataSource.fetchCard("1")
        } returns MockData.card1

        val imageLoader = mockk<ImageLoader>()

        val getClassicCardsUseCase = GetSelectCardUseCase(cardDataSource)

        val viewModel = CardDetailViewModel(getClassicCardsUseCase, imageLoader)

        viewModel.getCardDetails("1")

        val card = viewModel.cardDetails.getOrAwaitValue()

        assertEquals("name1", card.name)
        assertEquals("flavor1", card.flavor)
    }
}


