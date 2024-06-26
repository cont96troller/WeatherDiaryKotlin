package com.example.data.repository

import android.util.Log
import androidx.core.content.contentValuesOf
import com.example.data.BuildConfig
import com.example.data.remote.api.OpenWeatherMapApi
import com.example.data.model.CurrentWeatherResponse
import com.example.data.model.Forecast
import com.example.data.model.ListWeatherResponse
import com.example.domain.model.CurrentWeather
import com.example.domain.model.ListWeather
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

    override fun getListWeather(
        lat: Double,
        lon: Double,
        cnt: Int,
        apiKey: String
    ): Flow<ListWeather> {
        return flow {
            val apiResult: ListWeatherResponse =
                api.getListWeather(lat, lon, cnt, apiKey = BuildConfig.WEATHER_API_KEY)
            val resultList: List<Forecast> = apiResult.list

            // resultList의 weather에 접근해
            //List<Forecast> 형변환을 하는데, -> List<ListWeather>
            val convertedList = resultList.map { forecast: Forecast ->
                emit(
                ListWeather(
                    main =forecast.weather.first().main,
                    description =forecast.weather.first().description,
                    icon = forecast.weather.first().icon
                ))
            }
        }
    }
}