package com.scafisystems.classichearthstonecards.data.api

import com.scafisystems.classichearthstonecards.domain.entity.Card
import retrofit2.http.GET

interface CardService {
    @GET("cards/sets/classic")
    suspend fun listClassicCards(): List<Card>
}