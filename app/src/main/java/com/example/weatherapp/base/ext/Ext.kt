package com.example.weatherapp.base.ext

import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

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
    if (this < 0) {
        "-$this"
    } else {
        "+$this"
    }