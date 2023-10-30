package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherapp.base.navigation.MainActivityNavigator
import com.example.weatherapp.base.navigation.Screens
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val navHolder by inject<NavigatorHolder>()
    private val navigator: Navigator = MainActivityNavigator(this, R.id.placeholder)
    private val router by inject<Router>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navHolder.setNavigator(navigator)
        router.newRootScreen(Screens.mainScreen())
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navHolder.removeNavigator()
    }
}