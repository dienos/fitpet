package jth.fitpet.data.api

import jth.fitpet.data.model.WeatherRepoRes
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET(WEATHER)
    suspend fun getWeathers(
        @Query("q") cityName: String, @Query("appid") appId: String = APP_KEY
    ): List<WeatherRepoRes>
}