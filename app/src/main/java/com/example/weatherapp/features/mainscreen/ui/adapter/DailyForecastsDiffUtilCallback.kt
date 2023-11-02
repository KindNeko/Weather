package com.example.weatherapp.features.mainscreen.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.weatherapp.features.mainscreen.domain.model.Day

class DailyForecastsDiffUtilCallback(
    private val oldForecasts: List<Day>,
    private val newForecasts: List<Day>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldForecasts.size

    override fun getNewListSize(): Int = newForecasts.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldForecasts[oldItemPosition] == newForecasts[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldForecasts[oldItemPosition] == newForecasts[newItemPosition]
    }
}

