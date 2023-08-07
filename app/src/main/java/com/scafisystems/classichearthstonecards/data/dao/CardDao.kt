package com.scafisystems.classichearthstonecards.data.dao

import com.scafisystems.classichearthstonecards.domain.entity.Card


data class CardDao(
    val cardId: String? = null,
    val img: String? = null,
    val name: String? = null,
    val flavor: String? = null,
    val text: String? = null, //descriçao curta
    val cardSet: String? = null,
    val type: String? = null,
    val faction: String? = null,
    val rarity: String? = null,
    val attack: Int? = null,
    val cost: Int? = null,
    val health: Int? = null
)

fun CardDao.mapToCard(): Card {
    return Card(
        cardId = cardId,
        img = img,
        name = name,
        flavor = flavor,
        text = text,
        cardSet = cardSet,
        type = type,
        faction = faction,
        rarity = rarity,
        attack = attack,
        cost = cost,
        health = health
    )
}