package com.example.weatherdiarykotlin.di

import com.example.data.remote.api.OpenWeatherMapApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideOpenWeatherMapApi(): OpenWeatherMapApi {
        return OpenWeatherMapApi.create("https://api.openweathermap.org")
    }
}