package com.example.weatherapp.features.mainscreen.data

import com.example.weatherapp.features.mainscreen.data.mapper.toDomain
import com.example.weatherapp.features.mainscreen.domain.model.Forecast

class WeatherRepositoryImpl(private val api: WeatherApi) : WeatherRepository {
    override suspend fun getForecast(city: String): Forecast =
        api.getForecast(city = city).toDomain()
}