package com.scafisystems.classichearthstonecards.domain.usecase


import com.scafisystems.classichearthstonecards.helper.MockData
import com.scafisystems.classichearthstonecards.domain.datasource.CardDataSource
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class GetSelectCardUseCaseTest {

    @Test
    fun shouldGetCardsWhenCalled() = runBlocking {

        val cardDataSource = mockk<CardDataSource>()
        coEvery {
            cardDataSource.fetchCard("1")
        } returns MockData.card1

        val useCase = GetSelectCardUseCase(cardDataSource)
        val card = useCase.invoke("1")

        assertEquals(card.name!!, "name1")
        assertEquals(card.attack!!, 1)
    }
}