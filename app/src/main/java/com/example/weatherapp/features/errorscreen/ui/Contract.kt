package com.example.weatherapp.features.errorscreen.ui

import com.example.weatherapp.base.core.ScreenArguments
import kotlinx.parcelize.Parcelize

object ErrorContract {
    @Parcelize
    data class ErrorScreenArguments(
        val errorText: String,
        val onButtonClick: (() -> Unit)
    ) : ScreenArguments
}