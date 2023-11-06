package com.example.weatherapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainFragmentTest : TestBase() {
    @Test
    fun testAllViewsAreDisplayed() {
        Thread.sleep(2000)
        onView(withId(R.id.tvTemperature)).check(matches(isDisplayed()))
        onView(withId(R.id.ivForecastIcon)).check(matches(isDisplayed()))
        onView(withId(R.id.tvForecast)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDate)).check(matches(isDisplayed()))
        onView(withId(R.id.rvContent)).check(matches(isDisplayed()))
        onView(withId(R.id.llWindSpeedAndHumidity)).check(matches(isDisplayed()))
    }
}