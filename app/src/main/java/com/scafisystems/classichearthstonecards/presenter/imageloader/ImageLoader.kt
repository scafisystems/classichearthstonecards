package com.scafisystems.classichearthstonecards.presenter.imageloader

import android.widget.ImageView

interface ImageLoader {
    fun displayImage(url: String?, imageView: ImageView)
}