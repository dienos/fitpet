package jth.fitpet.data.repository

import jth.fitpet.data.datasource.WeatherRemoteSource
import jth.fitpet.domain.model.WeatherRepo
import jth.fitpet.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val remoteSource: WeatherRemoteSource
) : WeatherRepository {
    override suspend fun getWeathers(cityName : String): List<WeatherRepo> = remoteSource.getWeathers(cityName)
}