package com.scafisystems.classichearthstonecards.domain.usecase

import com.scafisystems.classichearthstonecards.helper.MockData.listOfCards
import com.scafisystems.classichearthstonecards.domain.datasource.CardDataSource
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class GetClassicCardsUseCaseTest {

    @Test
    fun shouldGetCardsWhenCalled() = runBlocking {

        val cardDataSource = mockk<CardDataSource>()
        coEvery {
            cardDataSource.fetchClassicCards()
        } returns listOfCards

        val useCase = GetClassicCardsUseCase(cardDataSource)
        val cards = useCase.invoke()

        assertEquals(cards.size, 2)
        assertEquals(cards.first().name!!, "name1")
        assertEquals(cards[1].name!!, "name2")
        assertEquals(cards.first().attack!!, 1)
        assertEquals(cards[1].attack!!, 2)
    }
}