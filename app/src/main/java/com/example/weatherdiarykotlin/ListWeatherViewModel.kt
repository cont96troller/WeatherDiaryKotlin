package com.example.weatherdiarykotlin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.BuildConfig
import com.example.domain.model.ListWeather
import com.example.domain.usecase.GetListWeatherUsCaseParams
import com.example.domain.usecase.GetWeatherListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListWeatherViewModel @Inject constructor(
    private val getListWeatherUseCase: GetWeatherListUseCase
) : ViewModel() {

    private val _listWeather = MutableStateFlow<ListWeather?>(null)
    val listWeather get() = _listWeather.asStateFlow()

    fun getListWeather(lat: Double, lon: Double, cnt: Int) {
        viewModelScope.launch {
            getListWeatherUseCase(
                GetListWeatherUsCaseParams(
                    lat, lon, 7, BuildConfig.WEATHER_API_KEY
                )
            ).collectLatest {
                _listWeather.value = it
            }
        }
    }
}