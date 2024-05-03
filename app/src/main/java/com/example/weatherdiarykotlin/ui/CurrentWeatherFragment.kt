package com.example.weatherdiarykotlin.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.weatherdiarykotlin.CurrentWeatherViewModel
import com.example.weatherdiarykotlin.databinding.FragmentWeatherCurrentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CurrentWeatherFragment : Fragment() {
    private lateinit var binding:FragmentWeatherCurrentBinding
    private val viewmodel: CurrentWeatherViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeatherCurrentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        collectData()

    }

    private fun collectData() {
        collectListWeatherData()
    }

    private fun collectListWeatherData() {
        viewmodel.getCurrentWeather(37.749, 128.87)
        lifecycleScope.launch {
            viewmodel.currentWeather.collectLatest { listWeather ->
                listWeather?.description.let { description ->
//                    Toast.makeText(requireContext(), description, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}