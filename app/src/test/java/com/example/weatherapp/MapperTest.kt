package com.example.weatherapp

import com.example.weatherapp.features.mainscreen.data.mapper.toDomain
import com.example.weatherapp.features.mainscreen.data.model.ConditionRemote
import com.example.weatherapp.features.mainscreen.data.model.CurrentForecastRemote
import com.example.weatherapp.features.mainscreen.data.model.DailyForecastRemote
import com.example.weatherapp.features.mainscreen.data.model.DailyRemote
import com.example.weatherapp.features.mainscreen.data.model.DayRemote
import com.example.weatherapp.features.mainscreen.data.model.ForecastRemote
import com.example.weatherapp.features.mainscreen.domain.model.CurrentForecast
import com.example.weatherapp.features.mainscreen.domain.model.DailyForecast
import com.example.weatherapp.features.mainscreen.domain.model.Day
import com.example.weatherapp.features.mainscreen.domain.model.Forecast
import org.junit.Assert.assertEquals
import org.junit.Test
import java.math.BigDecimal
import java.time.LocalDate

class MapperTest {
    @Test
    fun `daily remote to day test`() {
        val expected = Day(
            date = "2023-10-31",
            iconUrl = "https://my.image.url/1.png"
        )
        val actual = DailyRemote(
            date = "2023-10-31",
            day = DayRemote(
                condition = ConditionRemote(
                    text = "ignored",
                    icon = "https://my.image.url/1.png"
                )
            )
        ).toDomain()

        assertEquals(expected, actual)
    }

    @Test
    fun `daily remotes to days test`() {
        val expected: List<Day> = listOf(
            Day(
                date = "2022-10-11",
                iconUrl = "https://my.image.url/1.png"
            ),
            Day(
                date = "2022-10-12",
                iconUrl = "https://my.image.url/1.png"
            ),
            Day(
                date = "2022-10-13",
                iconUrl = "https://my.image.url/1.png"
            ),
            Day(
                date = "2022-10-14",
                iconUrl = "https://my.image.url/1.png"
            )
        )
        val actual: List<Day> = listOf(
            DailyRemote(
                date = LocalDate.now().toString(),
                day = DayRemote(
                    condition = ConditionRemote(
                        text = "ignored",
                        icon = "https://my.image.url/1.png"
                    )
                )
            ),
            DailyRemote(
                date = "2022-10-11",
                day = DayRemote(
                    condition = ConditionRemote(
                        text = "ignored",
                        icon = "https://my.image.url/1.png"
                    )
                )
            ),
            DailyRemote(
                date = "2022-10-12",
                day = DayRemote(
                    condition = ConditionRemote(
                        text = "ignored",
                        icon = "https://my.image.url/1.png"
                    )
                )
            ),
            DailyRemote(
                date = "2022-10-13",
                day = DayRemote(
                    condition = ConditionRemote(
                        text = "ignored",
                        icon = "https://my.image.url/1.png"
                    )
                )
            ),
            DailyRemote(
                date = "2022-10-14",
                day = DayRemote(
                    condition = ConditionRemote(
                        text = "ignored",
                        icon = "https://my.image.url/1.png"
                    )
                )
            )
        ).toDomain()

        assertEquals(expected, actual)
        assertEquals(expected.size, actual.size)
    }

    @Test
    fun `forecast remote to forecast test`() {
        val expected = Forecast(
            current = CurrentForecast(
                temperature = 15,
                weather = "Windy",
                iconUrl = "https://my.image.url/1.png",
                windSpeed = BigDecimal("1.2"),
                humidity = 80
            ),
            daily = DailyForecast(
                days = listOf(
                    Day(
                        date = "2022-10-13",
                        iconUrl = "https://my.image.url/1.png"
                    ),
                    Day(
                        date = "2022-10-14",
                        iconUrl = "https://my.image.url/1.png"
                    )
                )
            )
        )

        val actual = ForecastRemote(
            current = CurrentForecastRemote(
                temperature = 15,
                condition = ConditionRemote(
                    text = "Windy",
                    icon = "https://my.image.url/1.png"
                ),
                windSpeed = 1.2,
                humidity = 80
            ),
            forecast = DailyForecastRemote(
                forecasts = listOf(
                    DailyRemote(
                        date = "2022-10-13",
                        day = DayRemote(
                            condition = ConditionRemote(
                                text = "ignored",
                                icon = "https://my.image.url/1.png"
                            )
                        )
                    ),
                    DailyRemote(
                        date = "2022-10-14",
                        day = DayRemote(
                            condition = ConditionRemote(
                                text = "ignored",
                                icon = "https://my.image.url/1.png"
                            )
                        )
                    )
                )
            )
        ).toDomain()

        assertEquals(expected, actual)
    }
}