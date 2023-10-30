package com.example.weatherapp.features.mainscreen.data

import com.example.weatherapp.features.mainscreen.domain.model.Forecast


interface WeatherRepository {
    suspend fun getForecast(city: String): Forecast
}

