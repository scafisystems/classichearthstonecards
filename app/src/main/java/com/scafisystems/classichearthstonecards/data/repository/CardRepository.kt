package com.scafisystems.classichearthstonecards.data.repository

import com.scafisystems.classichearthstonecards.data.api.reqApi
import com.scafisystems.classichearthstonecards.domain.datasource.CardDataSource
import com.scafisystems.classichearthstonecards.domain.entity.Card


class CardRepository : CardDataSource {

    override suspend fun fetchClassicCards(): List<Card> {
        return reqApi.listClassicCards()
    }
}
