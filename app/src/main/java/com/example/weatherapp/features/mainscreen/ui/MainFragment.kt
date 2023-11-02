package com.example.weatherapp.features.mainscreen.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.adapter.HorizontalAdapter
import com.example.weatherapp.base.ext.asFormattedString
import com.example.weatherapp.base.ext.asText
import com.example.weatherapp.base.ext.loadImage
import com.example.weatherapp.databinding.FragmentMainBinding
import com.example.weatherapp.features.mainscreen.domain.WeatherInteractor
import com.example.weatherapp.features.mainscreen.ui.adapter.DailyForecastsAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject


class MainFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val interactor by inject<WeatherInteractor>()
    private val dailyForecastsAdapter: DailyForecastsAdapter by lazy {
        DailyForecastsAdapter(emptyList())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        with(binding) {


            runBlocking {
                withContext(Dispatchers.IO) {
                    val forecast = interactor.getForecast("Moscow")

                    tvTemperature.text = forecast.current.temperature.asText()

                    tvWind.text = requireContext().getString(
                        R.string.wind_template,
                        forecast.current.windSpeed.asFormattedString()
                    )

                    tvHumidity.text = requireContext().getString(
                        R.string.humidity_template,
                        forecast.current.humidity
                    )
//                    ivTest.loadImage(forecast.current.iconUrl)

                    with(tvForecast) {
                        text = forecast.current.weather

                    }

                    dailyForecastsAdapter.updateList(forecast.daily.days)

                }
            }

        }

    }

    private fun initAdapter() {
        binding.rvContent.apply {
            adapter = dailyForecastsAdapter
            layoutManager = object : LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            ) {
                override fun canScrollHorizontally(): Boolean {
                    return false
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}