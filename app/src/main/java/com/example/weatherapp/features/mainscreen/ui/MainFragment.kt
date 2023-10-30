package com.example.weatherapp.features.mainscreen.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weatherapp.R
import com.example.weatherapp.base.ext.asFormattedString
import com.example.weatherapp.base.ext.iconLeft
import com.example.weatherapp.databinding.FragmentMainBinding
import com.example.weatherapp.features.mainscreen.domain.WeatherInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject
import java.math.BigDecimal


class MainFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val interactor by inject<WeatherInteractor>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {


            runBlocking {
                withContext(Dispatchers.IO) {
                    val forecast = interactor.getForecast("Moscow")
                    tvTemperature.text = forecast.current.temperature.toString()
                    tvWind.text = requireContext().getString(
                        R.string.wind_template,
                        forecast.current.windSpeed.asFormattedString()
                    )

                    tvHumidity.text = requireContext().getString(R.string.humidity_template, forecast.current.humidity)

                    with(tvForecast) {
                        text = forecast.current.weather
                        iconLeft(forecast.current.iconUrl)
                    }
                }
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}