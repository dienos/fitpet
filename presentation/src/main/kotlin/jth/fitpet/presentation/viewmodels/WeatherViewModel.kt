package jth.fitpet.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jth.fitpet.domain.model.CityPoint
import jth.fitpet.domain.model.WeatherRepo
import jth.fitpet.domain.usecase.GetWeathersUseCase
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeathersUseCase: GetWeathersUseCase
) : BaseViewModel() {
    data class LocalWeatherData(val list: ArrayList<WeatherRepo>)

    val weatherRepoData = MutableLiveData<LocalWeatherData>()

    fun getWeathers() {
        val resultData: ArrayList<WeatherRepo> = arrayListOf()

        getWeathersUseCase(CityPoint.SEOUL.lat, CityPoint.SEOUL.lon, viewModelScope, {
            resultData.add(it)

            getWeathersUseCase(CityPoint.LONDON.lat, CityPoint.LONDON.lon, viewModelScope, {
                resultData.add(it)

                getWeathersUseCase(CityPoint.CHICAGO.lat, CityPoint.CHICAGO.lon, viewModelScope, {
                    resultData.add(it)

                    weatherRepoData.value = LocalWeatherData(resultData)
                }, {
                    resultData.clear()
                }
                )
            }, {
                resultData.clear()
            }
            )

        }, {
            resultData.clear()
        }
        )
    }
}