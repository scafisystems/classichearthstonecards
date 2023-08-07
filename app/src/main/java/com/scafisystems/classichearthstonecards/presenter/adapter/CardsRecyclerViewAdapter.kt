package com.scafisystems.classichearthstonecards.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.scafisystems.classichearthstonecards.R
import com.scafisystems.classichearthstonecards.databinding.CardListItemBinding
import com.scafisystems.classichearthstonecards.domain.entity.Card
import com.scafisystems.classichearthstonecards.presenter.imageloader.ImageLoader

class CardsRecyclerViewAdapter(
    private val classicCardsList: List<Card>,
    private val imageLoader: ImageLoader,
    private val clickListener: (Card) -> Unit
) : RecyclerView.Adapter<CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding: CardListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.card_list_item, parent, false
        )
        return CardViewHolder(binding, imageLoader)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = classicCardsList[position]
        holder.bind(card, clickListener)
    }

    override fun getItemCount(): Int = classicCardsList.size
}


class CardViewHolder(
    private val binding: CardListItemBinding,
    private val imageLoader: ImageLoader,
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(card: Card, clickListener: (Card) -> Unit) {
        binding.apply {
            tvCardName.text = card.name
            tvCardDesc.text = card.flavor
            imageLoader.displayImage(card.img, imgCardImg)
            binding.root.setOnClickListener { clickListener(card) }
        }
    }
}