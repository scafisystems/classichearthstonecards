package com.scafisystems.classichearthstonecards.data.repository

import com.scafisystems.classichearthstonecards.data.api.reqApi
import com.scafisystems.classichearthstonecards.data.dao.mapToCard
import com.scafisystems.classichearthstonecards.domain.datasource.CardDataSource
import com.scafisystems.classichearthstonecards.domain.entity.Card


class CardRepository : CardDataSource {

    override suspend fun fetchCard(cardId: String): Card {
        return reqApi.card(cardId).first().mapToCard()
    }

    override suspend fun fetchClassicCards(): List<Card> {
        return reqApi.listClassicCards()
    }
}
