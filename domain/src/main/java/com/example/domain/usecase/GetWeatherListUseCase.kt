package com.example.domain.usecase

import com.example.domain.model.ListWeather
import com.example.domain.repository.OpenWeatherMapRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeatherListUseCase @Inject constructor(
    private val weatherMapRepository: OpenWeatherMapRepository
) : FlowUseCase<GetListWeatherUsCaseParams, ListWeather>() {
    override fun execute(parameters: GetListWeatherUsCaseParams): Flow<ListWeather> {
        return weatherMapRepository.getListWeather(
            parameters.lat,
            parameters.lon,
            parameters.cnt,
            parameters.apikey
        )
    }
}

data class GetListWeatherUsCaseParams(val lat: Double, val lon: Double, val cnt: Int, val apikey: String)