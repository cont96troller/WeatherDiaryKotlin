package com.example.domain.usecase

import com.example.domain.model.CurrentWeather
import com.example.domain.repository.OpenWeatherMapRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCurrentWeatherUseCase @Inject constructor(
    private val weatherMapRepository: OpenWeatherMapRepository
) : FlowUseCase<GetCurrentWeatherUseCaseParams, CurrentWeather>() {
    override fun execute(parameters: GetCurrentWeatherUseCaseParams): Flow<CurrentWeather> {
        return weatherMapRepository.getCurrentWeather(
            parameters.lat,
            parameters.lon,
            parameters.apiKey
        )
    }
}

data class GetCurrentWeatherUseCaseParams(val lat: Double, val lon: Double, val apiKey: String)