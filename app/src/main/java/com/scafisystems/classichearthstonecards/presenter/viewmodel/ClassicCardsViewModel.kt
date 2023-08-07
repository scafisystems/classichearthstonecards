package com.scafisystems.classichearthstonecards.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scafisystems.classichearthstonecards.domain.entity.Card
import com.scafisystems.classichearthstonecards.domain.usecase.GetClassicCardsUseCase
import com.scafisystems.classichearthstonecards.presenter.imageloader.ImageLoader
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClassicCardsViewModel @Inject constructor(
    private val getClassicCardsUseCase: GetClassicCardsUseCase,
    val imageLoader: ImageLoader
) : ViewModel() {


    private val _listClassicCards = MutableLiveData<List<Card>>().apply {
        viewModelScope.launch {
            value = getClassicCardsUseCase
                .invoke()
                .filter {
                    validateData(it)
                }

        }
    }
    val listOfClassicCards: LiveData<List<Card>> = _listClassicCards

    private fun validateData(card: Card): Boolean {
        return !card.img.isNullOrEmpty() && !card.name.isNullOrEmpty() && !card.flavor.isNullOrEmpty()
    }
}