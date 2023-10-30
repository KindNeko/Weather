package com.example.weatherapp.base.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

const val BASE_URL = "http://api.weatherapi.com"

private fun logging() = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

fun okHttp(): OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(logging())
    .build()