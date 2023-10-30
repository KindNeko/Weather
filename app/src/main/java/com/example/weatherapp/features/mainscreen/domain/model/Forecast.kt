package com.example.weatherapp.features.mainscreen.domain.model

import java.math.BigDecimal

data class Forecast(
    val current: CurrentForecast,
    val daily: DailyForecast
)

data class CurrentForecast(
    val temperature: Int,
    val weather: String,
    val iconUrl: String,
    val windSpeed: BigDecimal,
    val humidity: Int
)

data class DailyForecast(
    val days: List<Day>
)

data class Day(
    val date: String,
    val iconUrl: String,
)
