package com.example.weatherapp.features.mainscreen.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.weatherapp.R
import com.example.weatherapp.base.ext.asFormattedString
import com.example.weatherapp.base.ext.asText
import com.example.weatherapp.base.ext.dayOfWeekName
import com.example.weatherapp.base.ext.formattedDate
import com.example.weatherapp.base.ext.loadImage
import com.example.weatherapp.databinding.FragmentMainBinding
import com.example.weatherapp.features.mainscreen.ui.adapter.ForecastDiffUtilCallback
import com.example.weatherapp.features.mainscreen.ui.adapter.dailyForecastDelegate
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import showIf
import java.time.LocalDate


class MainFragment : Fragment(R.layout.fragment_main) {

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }

    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)
    private val viewModel: MainFragmentViewModel by viewModel()
    private val dailyForecastsAdapter by lazy {
        AsyncListDifferDelegationAdapter(
            ForecastDiffUtilCallback(),
            dailyForecastDelegate()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        viewModel.viewState.observe(viewLifecycleOwner, ::render)
    }

    private fun initAdapter() {
        binding.rvContent.apply {
            adapter = dailyForecastsAdapter
            layoutManager = object : LinearLayoutManager(
                requireContext(),
                HORIZONTAL,
                false
            ) {
                override fun canScrollHorizontally(): Boolean {
                    return false
                }
            }
        }
    }

    private fun render(viewState: ForecastContract.ViewState) {
        renderProgress(viewState.isLoading)
        renderContent(viewState)
    }

    private fun renderProgress(isLoading: Boolean) {
        binding.prBar.showIf { isLoading }
    }

    private fun renderContent(viewState: ForecastContract.ViewState) {
        val forecast = viewState.forecast
        with(binding) {
            groupContent.showIf { !viewState.isLoading }
            tvTemperature.text = requireContext().getString(
                R.string.temperature_template,
                forecast.current.temperature.asText()
            )
            ivForecastIcon.loadImage(forecast.current.iconUrl)
            tvForecast.text = forecast.current.weather
            tvDate.text = requireContext().getString(
                R.string.date_template,
                LocalDate.now().dayOfWeekName(),
                LocalDate.now().formattedDate()
            )
            dailyForecastsAdapter.items = forecast.daily.days
            tvWind.text = requireContext().getString(
                R.string.wind_template,
                forecast.current.windSpeed.asFormattedString()
            )
            tvHumidity.text = requireContext().getString(
                R.string.humidity_template,
                forecast.current.humidity
            )
        }
    }
}