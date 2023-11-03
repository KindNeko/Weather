package com.example.weatherapp.base.ext

import com.example.weatherapp.features.mainscreen.domain.model.CurrentForecast
import com.example.weatherapp.features.mainscreen.domain.model.DailyForecast
import com.example.weatherapp.features.mainscreen.domain.model.Forecast

private fun DailyForecast.isEmpty(): Boolean = this.days.isEmpty()

private fun CurrentForecast.isEmpty(): Boolean = this.temperature.isZero()
        && this.weather.isEmpty()
        && this.iconUrl.isEmpty()
        && this.windSpeed.isZero()
        && this.humidity.isZero()

fun Forecast.isEmpty(): Boolean {
    return this.current.isEmpty() && this.daily.isEmpty()
}