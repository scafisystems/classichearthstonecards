package com.scafisystems.classichearthstonecards.presenter.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.scafisystems.classichearthstonecards.domain.datasource.CardDataSource
import com.scafisystems.classichearthstonecards.domain.usecase.GetClassicCardsUseCase
import com.scafisystems.classichearthstonecards.helper.MockData.listOfCards
import com.scafisystems.classichearthstonecards.helper.MockData.listOfCardsWithInvalidCards
import com.scafisystems.classichearthstonecards.helper.LiveDataHelper.getOrAwaitValue
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

class ClassicCardsViewModelTest {
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
            cardDataSource.fetchClassicCards()
        } returns listOfCards

        val imageLoader = mockk<ImageLoader>()

        val getClassicCardsUseCase = GetClassicCardsUseCase(cardDataSource)

        val viewModel = ClassicCardsViewModel(getClassicCardsUseCase, imageLoader)

        assertEquals(2, viewModel.listOfClassicCards.getOrAwaitValue().size)
    }

    @Test
    fun shouldNotValidateDataWhenCardHasNoBasicInfo() {
        val cardDataSource = mockk<CardDataSource>()
        coEvery {
            cardDataSource.fetchClassicCards()
        } returns listOfCardsWithInvalidCards

        val imageLoader = mockk<ImageLoader>()

        val getClassicCardsUseCase = GetClassicCardsUseCase(cardDataSource)

        val viewModel = ClassicCardsViewModel(getClassicCardsUseCase, imageLoader)

        assertEquals(2, viewModel.listOfClassicCards.getOrAwaitValue().size)
    }
}