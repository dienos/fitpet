package jth.fitpet.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jth.fitpet.domain.model.WeatherRepo
import jth.fitpet.domain.usecase.GetWeathersUseCase
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeathersUseCase: GetWeathersUseCase
) : BaseViewModel() {

    private val weatherData = MutableLiveData<WeatherRepo>()

    fun getWeathers() {
        getWeathersUseCase(52f, 33f, viewModelScope, {
            weatherData.value = it
        }, {

            }
        )
    }
}