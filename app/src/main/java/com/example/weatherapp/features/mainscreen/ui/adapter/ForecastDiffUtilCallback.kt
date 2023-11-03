package com.example.weatherapp.features.mainscreen.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.weatherapp.features.mainscreen.domain.model.Day

class ForecastDiffUtilCallback : DiffUtil.ItemCallback<Day>() {
    override fun areItemsTheSame(oldItem: Day, newItem: Day): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Day, newItem: Day): Boolean {
        return oldItem == newItem
    }
}