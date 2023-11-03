package com.example.weatherapp.base.ext

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(src: String) {
    Glide.with(context)
        .load("https:$src")
        .centerInside()
        .into(this)
}