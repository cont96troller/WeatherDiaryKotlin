package com.example.weatherdiarykotlin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.model.ListWeather
import com.example.weatherdiarykotlin.WeatherListAdapter
import com.example.weatherdiarykotlin.databinding.FragmentListWeatherBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherListFragment : Fragment() {
    private lateinit var binding : FragmentListWeatherBinding
    private lateinit var adapter:WeatherListAdapter

    val data = mutableListOf<ListWeather>()

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
        initialList()
        WeatherListRecyclerView()
    }

    private fun WeatherListRecyclerView() {
        val adapter = WeatherListAdapter()
        adapter.datalist=data
        binding.recyclerView.adapter=adapter
        binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())

    }

    private fun initialList() {
        with(data) {
            add(ListWeather("맑음"))
            add(ListWeather("흐림"))
            add(ListWeather("좋음"))
            add(ListWeather("나쁨"))
        }
    }
}