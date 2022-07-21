package jth.fitpet.data.datasource

import jth.fitpet.data.api.WeatherService
import jth.fitpet.data.model.WeatherRepoRes
import javax.inject.Inject

interface WeatherRemoteSource {
    suspend fun getWeathers(lat: Float, lon: Float): WeatherRepoRes
}

class WeatherRemoteSourceImpl @Inject constructor(
    private val service: WeatherService
) : WeatherRemoteSource {
    override suspend fun getWeathers(lat: Float, lon: Float): WeatherRepoRes =
        service.getWeathers(lat, lon)
}