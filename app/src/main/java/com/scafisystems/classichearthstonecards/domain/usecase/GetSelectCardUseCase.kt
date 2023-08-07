package com.scafisystems.classichearthstonecards.domain.usecase

import com.scafisystems.classichearthstonecards.domain.datasource.CardDataSource
import com.scafisystems.classichearthstonecards.domain.entity.Card


class GetSelectCardUseCase(
    private val dataSource: CardDataSource
) {
    suspend operator fun invoke(cardId: String): Card = dataSource.fetchCard(cardId)
}