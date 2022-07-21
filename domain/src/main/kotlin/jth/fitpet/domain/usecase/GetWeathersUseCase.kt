package jth.fitpet.domain.usecase

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import jth.fitpet.domain.model.WeatherRepo
import jth.fitpet.domain.repository.WeatherRepository

class GetWeathersUseCase(private val repository: WeatherRepository) {
    operator fun invoke(
        lat : Float,
        lon : Float,
        scope: CoroutineScope,
        onResult: (WeatherRepo) -> Unit = {},
        onFail: (Exception) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                try {
                    repository.getWeathers(lat, lon)
                } catch (e : Exception) {
                    onFail(e)
                }
            }

            val result = deferred.await()

            if(result is WeatherRepo) {
                onResult(result)
            }
        }
    }
}