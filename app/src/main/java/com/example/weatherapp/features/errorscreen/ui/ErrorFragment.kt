package com.example.weatherapp.features.errorscreen.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.weatherapp.R
import com.example.weatherapp.base.core.ScreenArguments
import com.example.weatherapp.base.core.getScreenArguments
import com.example.weatherapp.base.core.saveScreenArguments
import com.example.weatherapp.databinding.ErrorFragmentBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import setThrottledClickListener

class ErrorFragment : Fragment(R.layout.error_fragment) {
    companion object {
        fun newInstance(screenArguments: ScreenArguments) = ErrorFragment().apply {
            saveScreenArguments(screenArguments)
        }
    }

    private val screenArguments: ErrorContract.ErrorScreenArguments by lazy { getScreenArguments() }
    private val viewBinding: ErrorFragmentBinding by viewBinding(ErrorFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewBinding) {
            tvError.text = screenArguments.errorText
            btnError.setThrottledClickListener {
                screenArguments.onButtonClick.invoke()
            }
        }
    }
}