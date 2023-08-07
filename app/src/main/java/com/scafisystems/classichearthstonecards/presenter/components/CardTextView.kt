package com.scafisystems.classichearthstonecards.presenter.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.LinearLayoutCompat
import com.scafisystems.classichearthstonecards.R
import com.scafisystems.classichearthstonecards.databinding.CardTextViewBinding

class CardTextView
constructor(
    context: Context,
    attrs: AttributeSet
) : LinearLayoutCompat(context, attrs) {

    private var title: String? = null
    private var description: String? = null

    private val binding: CardTextViewBinding = CardTextViewBinding
        .inflate(LayoutInflater.from(context), this, true)


    init {
        inflate(context, R.layout.card_text_view, this)
        setLayout(attrs)
    }

    private fun setLayout(attrs: AttributeSet?) {
        attrs?.let { attributeSet ->
            val attributes = context.obtainStyledAttributes(attributeSet, R.styleable.CardTextView)

            setBackgroundResource(R.drawable.card_text_view_background)

            val titleResourceId = attributes.getResourceId(R.styleable.CardTextView_title, 0)
            if (titleResourceId != 0) {
                title = context.getString(titleResourceId)
            }
            val descriptionResourceId =
                attributes.getResourceId(R.styleable.CardTextView_description, 0)
            if (descriptionResourceId != 0) {
                description = context.getString(descriptionResourceId)
            }

            binding.title.text = title
            binding.desc.text = description

            attributes.recycle()
        }
    }


    fun setTitle(title: String) {
        binding.title.text = title
        refreshDrawableState()
    }

    fun setDescription(description: String) {
        binding.desc.text = description
        refreshDrawableState()
    }
}