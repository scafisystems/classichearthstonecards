package com.scafisystems.classichearthstonecards.domain.datasource

import com.scafisystems.classichearthstonecards.domain.entity.Card

interface CardDataSource {
    suspend fun fetchCard(cardId: String): Card
    suspend fun fetchClassicCards(): List<Card>
}