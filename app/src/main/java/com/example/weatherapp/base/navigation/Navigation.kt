package com.example.weatherapp.base.navigation

import com.example.weatherapp.fragments.MainFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun mainScreen() = FragmentScreen {
        MainFragment.newInstance()
    }
}