package com.example.weatherapp.features.mainscreen.di

import com.example.weatherapp.features.mainscreen.data.WeatherApi
import com.example.weatherapp.features.mainscreen.data.WeatherFakeRepository
import com.example.weatherapp.features.mainscreen.data.WeatherRepository
import com.example.weatherapp.features.mainscreen.data.WeatherRepositoryImpl
import com.example.weatherapp.features.mainscreen.domain.WeatherInteractor
import com.example.weatherapp.features.mainscreen.ui.MainFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

val weatherModule = module {
    single<WeatherApi> {
        get<Retrofit>().create()
    }

    single<WeatherRepository> {
        WeatherRepositoryImpl(get())
    }

    single<WeatherInteractor> {
        WeatherInteractor(get())
    }

    viewModel<MainFragmentViewModel> {
        MainFragmentViewModel(
            interactor = get(),
            router = get()
        )
    }
}