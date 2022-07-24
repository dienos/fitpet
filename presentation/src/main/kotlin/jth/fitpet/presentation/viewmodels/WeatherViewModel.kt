package jth.fitpet.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jth.fitpet.domain.model.CityPoint
import jth.fitpet.domain.model.LocationData
import jth.fitpet.domain.model.WeatherRepo
import jth.fitpet.domain.usecase.GetWeathersUseCase
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeathersUseCase: GetWeathersUseCase
) : BaseViewModel() {
    data class LocalWeatherData(val list: List<WeatherRepo>)
    val localWeatherRepoData = MutableLiveData<LocalWeatherData>()

    private fun getLocationData(cityName: String): LocationData = when (cityName) {
        CityPoint.SEOUL.cityName -> {
            LocationData(CityPoint.SEOUL.lat, CityPoint.SEOUL.lon)
        }

        CityPoint.LONDON.cityName -> {
            LocationData(CityPoint.LONDON.lat, CityPoint.LONDON.lon)
        }

        CityPoint.CHICAGO.cityName -> {
            LocationData(CityPoint.CHICAGO.lat, CityPoint.CHICAGO.lon)
        }

        else ->
            LocationData(0f, 0f)
    }

    fun getWeathers() {
        updateProgress(true)

        val locationData: ArrayList<LocationData> = arrayListOf()
        locationData.add(getLocationData(CityPoint.SEOUL.cityName))
        locationData.add(getLocationData(CityPoint.LONDON.cityName))
        locationData.add(getLocationData(CityPoint.CHICAGO.cityName))

        getWeathersUseCase(locationData, viewModelScope, {
            updateProgress(false)
            localWeatherRepoData.value = LocalWeatherData(it)
        }, {
            updateToast(it)
            updateProgress(false)
        })
    }
}