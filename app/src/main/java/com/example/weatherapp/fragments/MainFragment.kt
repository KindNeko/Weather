package com.example.weatherapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weatherapp.R
import com.example.weatherapp.base.ext.asFormattedString
import com.example.weatherapp.databinding.FragmentMainBinding
import java.math.BigDecimal


class MainFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

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
            tvWind.text = requireContext().getString(R.string.wind_template, BigDecimal(10.0031).asFormattedString())
            tvHumidity.text = requireContext().getString(R.string.humidity_template, "54")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}