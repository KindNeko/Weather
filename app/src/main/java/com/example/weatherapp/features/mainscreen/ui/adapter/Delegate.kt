package com.example.weatherapp.features.mainscreen.ui.adapter

import com.example.weatherapp.base.ext.dayOfWeekName
import com.example.weatherapp.base.ext.loadImage
import com.example.weatherapp.databinding.RowBinding
import com.example.weatherapp.features.mainscreen.domain.model.Day
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import java.time.LocalDate
import java.time.format.TextStyle

fun dailyForecastDelegate() =
    adapterDelegateViewBinding<Day, Day, RowBinding>({ layoutInflater, parent ->
        RowBinding.inflate(layoutInflater, parent, false)
    }) {
        fun renderImage() {
            binding.ivImage.loadImage(item.iconUrl)
        }

        fun renderDay() {
            binding.tvDay.text = LocalDate.parse(item.date).dayOfWeekName(style = TextStyle.SHORT)
        }

        bind {
            renderImage()
            renderDay()
        }
    }