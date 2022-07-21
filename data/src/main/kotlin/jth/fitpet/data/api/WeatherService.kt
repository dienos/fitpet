package jth.fitpet.data.api

import jth.fitpet.data.model.WeatherRepoRes
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface WeatherService {
    @GET(WEATHER)
    suspend fun getWeathers(
        @Query("lat") lat: Float,
        @Query("lon") lon: Float,
        @Query("cnt") count: Int = 6,
        @Query("units") units : String = "metric",
        @Query("appid") appId: String = APP_KEY
    ): WeatherRepoRes
}