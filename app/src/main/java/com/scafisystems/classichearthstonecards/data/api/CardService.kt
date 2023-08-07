package com.scafisystems.classichearthstonecards.data.api

import com.scafisystems.classichearthstonecards.data.dao.CardDao
import com.scafisystems.classichearthstonecards.domain.entity.Card

import retrofit2.http.GET
import retrofit2.http.Path

interface CardService {

    @GET("cards/{cardId}")
    suspend fun card(@Path("cardId") cardId: String): List<CardDao>

    @GET("cards/sets/classic")
    suspend fun listClassicCards(): List<Card>
}