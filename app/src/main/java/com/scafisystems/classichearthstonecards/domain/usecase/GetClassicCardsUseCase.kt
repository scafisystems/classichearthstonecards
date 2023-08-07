package com.scafisystems.classichearthstonecards.domain.usecase

import com.scafisystems.classichearthstonecards.domain.datasource.CardDataSource
import com.scafisystems.classichearthstonecards.domain.entity.Card


class GetClassicCardsUseCase(
    private val dataSource: CardDataSource,
) {
    suspend operator fun invoke(): List<Card> = dataSource.fetchClassicCards()
}