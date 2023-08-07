package com.scafisystems.classichearthstonecards.presenter.viewmodel

import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scafisystems.classichearthstonecards.domain.entity.Card
import com.scafisystems.classichearthstonecards.domain.usecase.GetSelectCardUseCase
import com.scafisystems.classichearthstonecards.presenter.imageloader.ImageLoader
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardDetailViewModel @Inject constructor(
    private val getSelectCardUseCase: GetSelectCardUseCase,
    private val imageLoader: ImageLoader
) : ViewModel() {

    private val _cardDetails = MutableLiveData<Card>()

    val cardDetails: LiveData<Card> = _cardDetails

    fun getCardDetails(cardId: String) {
        viewModelScope.launch {
            _cardDetails.value = getSelectCardUseCase
                .invoke(cardId)
        }
    }

    fun displayImage(url: String?, imageView: ImageView) {
        imageLoader.displayImage(url, imageView)
    }
}