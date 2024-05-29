package com.example.data.model

import com.google.gson.annotations.SerializedName

data class ListWeatherResponse(
    @SerializedName("city")
    val city: City,
    @SerializedName("cod")
    val cod: String,
    @SerializedName("message")
    val message: Double,
    @SerializedName("cnt")
    val cnt: Int,
    @SerializedName("list")
    val list: List<Forecast>
)
data class City(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("coord")
    val coord: Coord,
    @SerializedName("country")
    val country: String,
    @SerializedName("population")
    val population: Int,
    @SerializedName("timezone")
    val timezone: Int
)

data class Coord(
    @SerializedName("lon")
    val lon: Double,
    @SerializedName("lat")
    val lat: Double
)

data class Temperature(
    @SerializedName("day")
    val day: Double,
    @SerializedName("min")
    val min: Double,
    @SerializedName("max")
    val max: Double,
    @SerializedName("night")
    val night: Double,
    @SerializedName("eve")
    val eve: Double,
    @SerializedName("morn")
    val morn: Double
)

data class FeelsLike(
    @SerializedName("day")
    val day: Double,
    @SerializedName("night")
    val night: Double,
    @SerializedName("eve")
    val eve: Double,
    @SerializedName("morn")
    val morn: Double
)

data class Weather(
    @SerializedName("id")
    val id: Int,
    @SerializedName("main")
    val main: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val icon: String
)

data class Forecast(
    @SerializedName("dt")
    val dt: Long,
    @SerializedName("sunrise")
    val sunrise: Long,
    @SerializedName("sunset")
    val sunset: Long,
    @SerializedName("temp")
    val temp: Temperature,
    @SerializedName("feels_like")
    val feelsLike: FeelsLike,
    @SerializedName("pressure")
    val pressure: Int,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("weather")
    val weather: List<Weather>,
    @SerializedName("speed")
    val speed: Double,
    @SerializedName("deg")
    val deg: Int,
    @SerializedName("gust")
    val gust: Double,
    @SerializedName("clouds")
    val clouds: Clouds,
    @SerializedName("pop")
    val pop: Double,
    @SerializedName("rain")
    val rain: Double?
)


