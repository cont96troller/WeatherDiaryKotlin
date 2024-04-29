package com.example.weatherdiarykotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.ListWeather
import com.example.weatherdiarykotlin.databinding.ItemWeatherListBinding

class WeatherListAdapter : RecyclerView.Adapter<WeatherListAdapter.ViewHolder>() {

    var datalist = mutableListOf<ListWeather>()

    class ViewHolder(private val binding: ItemWeatherListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listWeather: ListWeather) {
            binding.txtWeatherStatus.text = listWeather.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemWeatherListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = datalist.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datalist[position])
    }
}

