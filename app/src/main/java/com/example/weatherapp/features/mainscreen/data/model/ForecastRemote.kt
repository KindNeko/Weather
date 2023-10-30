package com.example.weatherapp.features.mainscreen.data.model

import com.google.gson.annotations.SerializedName

data class ForecastRemote(
    @SerializedName("current")
    val current: CurrentForecastRemote,
    @SerializedName("forecast")
    val forecast: DailyForecastRemote
)

data class ConditionRemote(
    @SerializedName("text")
    val text: String,
    @SerializedName("icon")
    val icon: String,
)

data class CurrentForecastRemote(
    @SerializedName("temp_c")
    val temperature: Int,
    @SerializedName("condition")
    val condition: ConditionRemote,
    @SerializedName("wind_kph")
    val windSpeed: Double,
    @SerializedName("humidity")
    val humidity: Int
)

data class DailyForecastRemote(
    @SerializedName("forecastday")
    val forecasts: List<DailyRemote>
)

data class DailyRemote(
    @SerializedName("date")
    val date: String,
    @SerializedName("day")
    val day: DayRemote
)

data class DayRemote(
    @SerializedName("condition")
    val condition: ConditionRemote
)