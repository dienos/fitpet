package jth.fitpet.domain.repository

import jth.fitpet.domain.model.WeatherRepo

interface WeatherRepository {
    suspend fun getWeathers(lat : Float, lon : Float) : WeatherRepo
}