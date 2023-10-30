package com.example.weatherapp.base.navigation

import androidx.fragment.app.FragmentActivity
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivityNavigator(
    activity: FragmentActivity,
    containerId: Int
) : AppNavigator(activity, containerId) {
    override fun applyCommands(commands: Array<out Command>) {
        super.applyCommands(commands)
        activity.supportFragmentManager.executePendingTransactions()
    }
}