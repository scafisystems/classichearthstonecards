package com.scafisystems.classichearthstonecards.domain.entity

data class Card(
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

