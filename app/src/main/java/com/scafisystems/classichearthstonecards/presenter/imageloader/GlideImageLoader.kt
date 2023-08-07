package com.scafisystems.classichearthstonecards.presenter.imageloader

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide


class GlideImageLoader(private val context: Context) : ImageLoader {

    private val circularProgressDrawable = CircularProgressDrawable(context).apply {
        strokeWidth = 5f
        centerRadius = 30f
        start()
    }


    override fun displayImage(url: String?, imageView: ImageView) {
        imageView.setImageDrawable(circularProgressDrawable)
        if (!url.isNullOrEmpty()) {
            Glide.with(context)
                .load(url)
                .into(imageView)
        }
    }
}

