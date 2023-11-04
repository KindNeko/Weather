package com.example.weatherapp

import com.example.weatherapp.base.ext.asFormattedString
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.math.BigDecimal

class BigDecimalFormatterTest {

    @Test
    fun `zero fractions test`() {
        val expected = "10"
        val actual = BigDecimal(10.0035).asFormattedString()

        assertEquals(expected, actual)
    }

    @Test
    fun `two digits fraction test`() {
        val expected = "10.25"
        val actual = BigDecimal(10.2535).asFormattedString()

        assertEquals(expected, actual)
    }

    @Test
    fun `one digit fraction test`() {
        val expected = "10.2"
        val actual = BigDecimal(10.2035).asFormattedString()

        assertEquals(expected, actual)
    }
}