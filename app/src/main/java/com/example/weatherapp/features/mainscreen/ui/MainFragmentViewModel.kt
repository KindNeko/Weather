package com.example.weatherapp.features.mainscreen.ui

import com.example.weatherapp.base.core.BaseViewModel
import com.example.weatherapp.base.core.Event
import com.example.weatherapp.base.navigation.Screens
import com.example.weatherapp.features.errorscreen.ui.ErrorContract
import com.example.weatherapp.features.mainscreen.domain.WeatherInteractor
import com.example.weatherapp.features.mainscreen.domain.model.CurrentForecast
import com.example.weatherapp.features.mainscreen.domain.model.DailyForecast
import com.example.weatherapp.features.mainscreen.domain.model.Forecast
import com.github.terrakok.cicerone.Router
import java.math.BigDecimal

class MainFragmentViewModel(
    private val interactor: WeatherInteractor,
    private val router: Router
) : BaseViewModel<ForecastContract.ViewState>() {

    init {
        processUiEvent(ForecastContract.UiEvent.FetchForecast)
    }

    override fun initialViewState(): ForecastContract.ViewState = ForecastContract.ViewState(
        forecast = Forecast(
            current = CurrentForecast(
                temperature = 0,
                weather = "",
                iconUrl = "",
                windSpeed = BigDecimal.ZERO,
                humidity = 0
            ),
            daily = DailyForecast(
                days = emptyList()
            )
        )
    )

    override suspend fun reduce(
        event: Event,
        previousState: ForecastContract.ViewState
    ): ForecastContract.ViewState? {
        when (event) {
            is ForecastContract.UiEvent.FetchForecast -> {
                interactor.getForecast("Moscow").fold(
                    onSuccess = { forecast ->
                        processDataEvent(ForecastContract.DataEvent.OnSuccessfulFetch(forecast))
                    },
                    onError = {
                        router.navigateTo(Screens.errorScreen(
                            ErrorContract.ErrorScreenArguments(
                                errorText = "Something went wrong",
                                onButtonClick = {
                                    router.exit()
                                    router.navigateTo(Screens.mainScreen())
                                }
                            )
                        ))
                    }
                )
            }

            is ForecastContract.DataEvent.OnSuccessfulFetch -> {
                return previousState.copy(event.forecast)
            }
        }

        return null
    }
}