package com.example.weatherapp.features.mainscreen.domain

import com.example.weatherapp.base.core.Either
import com.example.weatherapp.base.ext.attempt
import com.example.weatherapp.features.mainscreen.data.WeatherRepository
import com.example.weatherapp.features.mainscreen.domain.model.Forecast

class WeatherInteractor(private val repository: WeatherRepository) {
    suspend fun getForecast(city: String): Either<Throwable, Forecast> = attempt {
        repository.getForecast(city)
    }
}