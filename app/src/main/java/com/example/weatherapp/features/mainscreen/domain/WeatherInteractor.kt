package com.example.weatherapp.features.mainscreen.domain

import com.example.weatherapp.features.mainscreen.data.WeatherRepository
import com.example.weatherapp.features.mainscreen.domain.model.Forecast

class WeatherInteractor(private val repository: WeatherRepository) {
    suspend fun getForecast(city: String): Forecast = repository.getForecast(city)
}