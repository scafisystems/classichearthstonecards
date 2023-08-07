package com.scafisystems.classichearthstonecards.presenter.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.scafisystems.classichearthstonecards.R
import com.scafisystems.classichearthstonecards.databinding.FragmentCardDetailsBinding
import com.scafisystems.classichearthstonecards.domain.entity.Card
import com.scafisystems.classichearthstonecards.presenter.utils.Constants.CARD_ID
import com.scafisystems.classichearthstonecards.presenter.utils.hide
import com.scafisystems.classichearthstonecards.presenter.utils.show
import com.scafisystems.classichearthstonecards.presenter.viewmodel.CardDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardDetailsFragment : Fragment() {

    private lateinit var binding: FragmentCardDetailsBinding
    private val viewModel: CardDetailViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_card_details, container, false)

        val cardId = requireArguments().getString(CARD_ID)
        cardId?.let { viewModel.getCardDetails(it) }

        setObservables()

        return binding.root
    }

    private fun setObservables() {
        viewModel.cardDetails.observe(viewLifecycleOwner) { card ->
            setupCard(card)

            binding.cardContent.show()
            binding.progressCircular.hide()
        }

    }

    private fun setupCard(card: Card) {
        viewModel.displayImage(card.img, binding.imgCardImg)

        context?.let {
            val emptyText = it.getString(R.string.txt_empty)
            binding.txtCardName.setDescription(card.name ?: emptyText)
            binding.txtCardFlavor.setDescription(card.flavor ?: emptyText)
            binding.txtCardShortDesc.setDescription(card.text ?: emptyText)
            binding.txtCardSet.setDescription(card.cardSet ?: emptyText)
            binding.txtCardType.setDescription(card.type ?: emptyText)
            binding.txtCardFaction.setDescription(card.faction ?: emptyText)
            binding.txtCardRarity.setDescription(card.rarity ?: emptyText)
            val attack = if (card.attack != null) card.attack.toString() else emptyText
            binding.txtCardAttack.setDescription(attack)
            val cost = if (card.cost != null) card.cost.toString() else emptyText
            binding.txtCardCost.setDescription(cost)
            val health = if (card.health != null) card.health.toString() else emptyText
            binding.txtCardHealth.setDescription(health)
        }
    }

}