package com.example.weatherapp.features.mainscreen.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.base.ext.dayOfWeekName
import com.example.weatherapp.base.ext.loadImage
import com.example.weatherapp.databinding.RowBinding
import com.example.weatherapp.features.mainscreen.domain.model.Day
import java.time.LocalDate
import java.time.format.TextStyle

class DailyForecastsAdapter(private var days: List<Day>) :
    RecyclerView.Adapter<DailyForecastsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(days[position])
    }

    override fun getItemCount(): Int = days.size

    inner class ViewHolder(private val binding: RowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(day: Day) {
            renderImage(day.iconUrl)
            renderDay(day.date)
        }

        private fun renderImage(url: String) {
            binding.ivImage.loadImage(url)
        }

        private fun renderDay(date: String) {
            binding.tvDay.text = LocalDate.parse(date).dayOfWeekName(style = TextStyle.SHORT)
        }
    }

    fun updateList(newDays: List<Day>) {
        val diffUtilCallback = DailyForecastsDiffUtilCallback(days, newDays)
        val diffResult = DiffUtil.calculateDiff(diffUtilCallback)
        diffResult.dispatchUpdatesTo(this)
        days = newDays
    }
}