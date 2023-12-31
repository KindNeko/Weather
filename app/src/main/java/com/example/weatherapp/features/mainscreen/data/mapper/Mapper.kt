package com.example.weatherapp.features.mainscreen.data.mapper

import com.example.weatherapp.features.mainscreen.data.model.DailyRemote
import com.example.weatherapp.features.mainscreen.data.model.ForecastRemote
import com.example.weatherapp.features.mainscreen.domain.model.CurrentForecast
import com.example.weatherapp.features.mainscreen.domain.model.DailyForecast
import com.example.weatherapp.features.mainscreen.domain.model.Day
import com.example.weatherapp.features.mainscreen.domain.model.Forecast
import java.time.LocalDate

fun DailyRemote.toDomain(): Day =
    Day(
        date = date,
        iconUrl = day.condition.icon
    )

fun List<DailyRemote>.toDomain(): List<Day> =
    this.map { it.toDomain() }.filter { it.date != LocalDate.now().toString() }

fun ForecastRemote.toDomain(): Forecast =
    Forecast(
        current = CurrentForecast(
            temperature = current.temperature,
            weather = current.condition.text,
            iconUrl = current.condition.icon,
            windSpeed = current.windSpeed.toBigDecimal(),
            humidity = current.humidity
        ),
        daily = DailyForecast(
            days = forecast.forecasts.toDomain()
        )
    )