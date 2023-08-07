package com.scafisystems.classichearthstonecards.helper

import com.scafisystems.classichearthstonecards.domain.entity.Card


object MockData {

    val card1 = Card(
        cardId = "1",
        img = "img1",
        name = "name1",
        flavor = "flavor1",
        cardSet = "cardSet1",
        type = "type1",
        rarity = "rarity1",
        attack = 1,
        cost = 1,
        health = 1
    )

    val card2 = Card(
        cardId = "2",
        img = "img2",
        name = "name2",
        flavor = "flavor2",
        cardSet = "cardSet2",
        type = "type2",
        rarity = "rarity2",
        attack = 2,
        cost = 2,
        health = 2
    )

    val card3 = Card(
        cardId = "3",
        img = "",
        name = "name2",
        flavor = "flavor2",
        cardSet = "cardSet2",
        type = "type2",
        rarity = "rarity2",
        attack = 2,
        cost = 2,
        health = 2
    )

    val card4 = Card(
        cardId = "4",
        img = "img4",
        name = null,
        flavor = "flavor2",
        cardSet = "cardSet2",
        type = "type2",
        rarity = "rarity2",
        attack = 2,
        cost = 2,
        health = 2
    )

    val listOfCards = listOf(card1, card2)
    val listOfCardsWithInvalidCards = listOf(card1, card2, card3, card4)
}