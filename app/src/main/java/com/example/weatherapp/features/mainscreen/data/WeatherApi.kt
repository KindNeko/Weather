package com.example.weatherapp.features.mainscreen.data

import com.example.weatherapp.features.mainscreen.data.model.ForecastRemote
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("/v1/forecast.json")
    suspend fun getForecast(
        @Query("q") city: String,
        @Query("key") key: String = "94a05bc4cbb9403baa7160802232810",
        @Query("days") days: Int = 5,
        @Query("alerts") alerts: String = "no",
        @Query("aqi") aqi: String = "no"
    ): ForecastRemote
}