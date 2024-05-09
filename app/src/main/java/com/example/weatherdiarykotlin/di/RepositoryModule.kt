package com.example.weatherdiarykotlin.di

import com.example.data.remote.api.OpenWeatherMapApi
import com.example.data.repository.OpenWeatherMapRepositoryImpl
import com.example.domain.repository.OpenWeatherMapRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideOpenWeatherMapRepository(openWeatherMapApi: OpenWeatherMapApi): OpenWeatherMapRepository =
        OpenWeatherMapRepositoryImpl(openWeatherMapApi)
}