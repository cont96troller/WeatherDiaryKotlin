package com.example.weatherdiarykotlin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.model.ListWeather
import com.example.weatherdiarykotlin.ListWeatherViewModel
import com.example.weatherdiarykotlin.WeatherListAdapter
import com.example.weatherdiarykotlin.databinding.FragmentListWeatherBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WeatherListFragment : Fragment() {
    private lateinit var binding: FragmentListWeatherBinding
    private lateinit var adapter: WeatherListAdapter
    private val viewmodel: ListWeatherViewModel by viewModels()
    private val data = mutableListOf<ListWeather>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListWeatherBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        collectData()
    }

    private fun WeatherListRecyclerView() {
        val adapter = WeatherListAdapter()
        adapter.datalist = data
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

    }

    private fun collectData() {
        collectListWeatherData()
    }

    private fun collectListWeatherData() {
        viewmodel.getListWeather(37.749, 128.87, 7)
        lifecycleScope.launch {
            viewmodel.listWeather.collectLatest { listWeather ->
                listWeather?.main?.let { main ->
                    listWeather.description.let { description ->
                        listWeather.icon.let { icon ->
                            with(data) {
                                WeatherListRecyclerView()
                                add(ListWeather(main, description, icon))
                            }
                        }
                    }
                }
            }
        }
    }
}