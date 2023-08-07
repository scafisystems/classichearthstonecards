package com.scafisystems.classichearthstonecards.presenter.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.scafisystems.classichearthstonecards.R
import com.scafisystems.classichearthstonecards.databinding.FragmentClassicCardsHomeBinding
import com.scafisystems.classichearthstonecards.domain.entity.Card
import com.scafisystems.classichearthstonecards.presenter.adapter.CardsRecyclerViewAdapter
import com.scafisystems.classichearthstonecards.presenter.utils.Constants.CARD_ID
import com.scafisystems.classichearthstonecards.presenter.utils.hide
import com.scafisystems.classichearthstonecards.presenter.utils.show
import com.scafisystems.classichearthstonecards.presenter.viewmodel.ClassicCardsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClassicCardsHomeFragment : Fragment() {

    private lateinit var binding: FragmentClassicCardsHomeBinding
    private val viewModel: ClassicCardsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_classic_cards_home,
            container,
            false
        )
        setObservers()
        return binding.root
    }

    private fun setObservers() {
        viewModel.listOfClassicCards.observe(viewLifecycleOwner) {
            setupRecyclerView(it)
            binding.progressCircular.hide()
        }
    }

    private fun setupRecyclerView(it: List<Card>) {
        binding.rvCards.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = CardsRecyclerViewAdapter(it, viewModel.imageLoader) {
                clickOnCard(it)
            }
            show()
        }
    }

    private fun clickOnCard(card: Card) {
        val bundle = bundleOf(CARD_ID to card.cardId)
        findNavController().navigate(
            R.id.action_classicCardsHomeFragment_to_cardDetailsFragment,
            bundle
        )
    }

}