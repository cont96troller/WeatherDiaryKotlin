package com.example.domain.repository

import com.example.domain.model.CurrentWeather
import kotlinx.coroutines.flow.Flow


interface OpenWeatherMapRepository {

    fun getCurrentWeather(lat: Double, lon: Double, apiKey: String): Flow<CurrentWeather>
}