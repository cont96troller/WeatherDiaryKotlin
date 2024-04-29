package com.example.data.api

import com.example.data.model.CurrentWeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherMapApi {
    companion object {
        fun create(baseUrl: String): OpenWeatherMapApi {
            return createRetrofit(baseUrl, OpenWeatherMapApi::class.java)
        }
    }

    @GET("data/2.5/weather")
    suspend fun getCurrentWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("apiKey") apiKey: String
    ): CurrentWeatherResponse
}