package com.example.data.repository

import com.example.data.BuildConfig
import com.example.data.api.OpenWeatherMapApi
import com.example.data.model.CurrentWeatherResponse
import com.example.domain.model.CurrentWeather
import com.example.domain.repository.OpenWeatherMapRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class OpenWeatherMapRepositoryImpl(private val api: OpenWeatherMapApi) : OpenWeatherMapRepository {
    override fun getCurrentWeather(
        lat: Double,
        lon: Double,
        apiKey: String
    ): Flow<CurrentWeather> {
        return flow {
            val apiResult: CurrentWeatherResponse =
                api.getCurrentWeather(lat, lon, apiKey = BuildConfig.WEATHER_API_KEY)
            val description = apiResult.weather.first().description
            emit(CurrentWeather(description = description))
        }
    }
}