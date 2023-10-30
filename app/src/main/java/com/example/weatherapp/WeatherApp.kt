package com.example.weatherapp

import android.app.Application
import com.example.weatherapp.base.di.navModule
import com.example.weatherapp.base.di.netModule
import com.example.weatherapp.features.mainscreen.di.weatherModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WeatherApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@WeatherApp)
            modules(navModule, netModule, weatherModule)
        }
    }
}