package jth.fitpet.domain.usecase

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import jth.fitpet.domain.model.WeatherRepo
import jth.fitpet.domain.repository.WeatherRepository

class GetWeathersUseCase(private val repository: WeatherRepository) {
    operator fun invoke(
        cityName : String,
        scope: CoroutineScope,
        onResult: (List<WeatherRepo>) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.getWeathers(cityName)
            }
            onResult(deferred.await())
        }
    }
}