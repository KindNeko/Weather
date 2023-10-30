package com.example.weatherapp.base.ext

import android.graphics.drawable.Drawable
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

fun TextView.iconLeft(src: String) {
    Glide.with(context)
        .load("https:" + src)
        .into(object : CustomTarget<Drawable>() {
            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                setCompoundDrawables(resource, null, null, null)
            }

            override fun onLoadCleared(placeholder: Drawable?) {
                setCompoundDrawables(placeholder, null, null, null)
            }
        })
}