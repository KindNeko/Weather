package com.example.weatherapp.features.mainscreen.data

import com.example.weatherapp.features.mainscreen.domain.model.CurrentForecast
import com.example.weatherapp.features.mainscreen.domain.model.DailyForecast
import com.example.weatherapp.features.mainscreen.domain.model.Day
import com.example.weatherapp.features.mainscreen.domain.model.Forecast
import java.math.BigDecimal

class WeatherFakeRepository : WeatherRepository {
    override suspend fun getForecast(city: String): Forecast =
        Forecast(
            current = CurrentForecast(
                temperature = 13,
                weather = "Cloudy",
                iconUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fru.freepik.com%2Fphotos%2F%25D0%25BA%25D0%25B0%25D1%2580%25D1%2582%25D0%25B8%25D0%25BD%25D0%25BA%25D0%25B8&psig=AOvVaw0LZ3nX_q9biy3qXIPhaNfh&ust=1698754212900000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCPiJkt3enYIDFQAAAAAdAAAAABAE",
                humidity = 86,
                windSpeed = BigDecimal(2.55)
            ),
            daily = DailyForecast(
                days = listOf(
                    Day(
                        date = "2023-11-10",
                        iconUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fru.freepik.com%2Fphotos%2F%25D0%25BA%25D0%25B0%25D1%2580%25D1%2582%25D0%25B8%25D0%25BD%25D0%25BA%25D0%25B8&psig=AOvVaw0LZ3nX_q9biy3qXIPhaNfh&ust=1698754212900000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCPiJkt3enYIDFQAAAAAdAAAAABAE",
                    ),
                    Day(
                        date = "2023-11-11",
                        iconUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fru.freepik.com%2Fphotos%2F%25D0%25BA%25D0%25B0%25D1%2580%25D1%2582%25D0%25B8%25D0%25BD%25D0%25BA%25D0%25B8&psig=AOvVaw0LZ3nX_q9biy3qXIPhaNfh&ust=1698754212900000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCPiJkt3enYIDFQAAAAAdAAAAABAE",
                    ),
                    Day(
                        date = "2023-11-12",
                        iconUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fru.freepik.com%2Fphotos%2F%25D0%25BA%25D0%25B0%25D1%2580%25D1%2582%25D0%25B8%25D0%25BD%25D0%25BA%25D0%25B8&psig=AOvVaw0LZ3nX_q9biy3qXIPhaNfh&ust=1698754212900000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCPiJkt3enYIDFQAAAAAdAAAAABAE",
                    )
                )
            )
        )
}

