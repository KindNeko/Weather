package com.example.weatherapp.base.core

import android.os.Parcelable
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

private const val KEY = "SCREEN_ARGUMENTS_KEY"

interface ScreenArguments : Parcelable

fun <T : ScreenArguments> Fragment.getScreenArguments() = requireArguments()
    .getParcelable<ScreenArguments>(KEY) as T

fun <T : ScreenArguments> Fragment.saveScreenArguments(screenArguments: T) {
    arguments = bundleOf(KEY to screenArguments)
}