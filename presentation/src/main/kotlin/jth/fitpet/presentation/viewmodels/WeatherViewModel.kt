package jth.fitpet.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jth.fitpet.data.model.City
import jth.fitpet.domain.model.WeatherRepo
import jth.fitpet.domain.usecase.GetWeathersUseCase
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeathersUseCase: GetWeathersUseCase
) : BaseViewModel() {

    private val _weatherData = MutableLiveData<List<WeatherRepo>>()
    val weatherData : LiveData<List<WeatherRepo>>
    get() = _weatherData

    fun getWeathers() {
        getWeathersUseCase(City.SEOUL.name, viewModelScope) {
            _weatherData.value = it
        }
    }
}