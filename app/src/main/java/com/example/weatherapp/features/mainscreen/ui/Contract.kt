package com.example.weatherapp.features.mainscreen.ui

import com.example.weatherapp.base.core.Event
import com.example.weatherapp.base.ext.isEmpty
import com.example.weatherapp.features.mainscreen.domain.model.Forecast

object ForecastContract {
    data class ViewState(val forecast: Forecast) {
        val isLoading = forecast.isEmpty()
    }

    sealed class UiEvent : Event {
        object FetchForecast : UiEvent()
    }

    sealed class DataEvent : Event {
        data class OnSuccessfulFetch(val forecast: Forecast) : DataEvent()
    }
}