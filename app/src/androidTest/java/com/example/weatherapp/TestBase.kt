package com.example.weatherapp

import org.junit.Rule
import androidx.test.ext.junit.rules.activityScenarioRule

open class TestBase {
    @get:Rule
    val activityScenarioRule = activityScenarioRule<MainActivity>()
}