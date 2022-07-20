package jth.fitpet.domain.repository

import jth.fitpet.domain.model.WeatherRepo

interface WeatherRepository {
    suspend fun getWeathers(cityName : String) : List<WeatherRepo>
}