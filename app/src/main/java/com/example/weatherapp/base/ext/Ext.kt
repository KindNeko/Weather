package com.example.weatherapp.base.ext

import com.example.weatherapp.base.core.Either
import com.example.weatherapp.features.mainscreen.domain.model.CurrentForecast
import com.example.weatherapp.features.mainscreen.domain.model.DailyForecast
import com.example.weatherapp.features.mainscreen.domain.model.Forecast
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

fun BigDecimal.asFormattedString(
    maximumFractionDigits: Int = 2,
    minimumFractionDigits: Int = 0,
    roundingMode: RoundingMode = RoundingMode.DOWN
): String {
    val decimalFormat = DecimalFormat().apply {
        this.maximumFractionDigits = maximumFractionDigits
        this.minimumFractionDigits = minimumFractionDigits
        this.roundingMode = roundingMode
        decimalFormatSymbols = DecimalFormatSymbols().apply {
            decimalSeparator = '.'
        }
    }
    return decimalFormat.format(this)
}

fun Int.asText(): String =
    when {
        this < 0 -> "-$this"
        this > 0 -> "+$this"
        else -> "0"
    }

fun LocalDate.dayOfWeekName(style: TextStyle = TextStyle.FULL): String {
    return this.dayOfWeek.getDisplayName(style, Locale.ENGLISH)
}

fun LocalDate.formattedDate(): String {
    return this.format(DateTimeFormatter.ofPattern("dd MMM uuuu"))
}

inline fun <reified T> attempt(func: () -> T): Either<Throwable, T> = try {
    Either.Right(func.invoke())
} catch (e: Throwable) {
    Either.Left(e)
}

fun BigDecimal.isZero(): Boolean = this == BigDecimal.ZERO

fun Int.isZero(): Boolean = this == 0