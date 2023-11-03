package com.example.weatherapp.base.navigation

import com.example.weatherapp.base.core.ScreenArguments
import com.example.weatherapp.features.errorscreen.ui.ErrorFragment
import com.example.weatherapp.features.mainscreen.ui.MainFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun mainScreen() = FragmentScreen {
        MainFragment.newInstance()
    }

    fun errorScreen(screenArguments: ScreenArguments) = FragmentScreen {
        ErrorFragment.newInstance(screenArguments)
    }
}