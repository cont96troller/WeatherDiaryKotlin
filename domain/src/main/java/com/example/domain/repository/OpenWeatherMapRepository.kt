package com.example.domain.repository

import com.example.domain.model.CurrentWeather
import com.example.domain.model.ListWeather
import kotlinx.coroutines.flow.Flow


interface OpenWeatherMapRepository {

    fun getCurrentWeather(lat: Double, lon: Double, apiKey: String): Flow<CurrentWeather>
    fun getListWeather(lat: Double, lon: Double, cnt: Int, apiKey: String): Flow<ListWeather>
}