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
        onFail: (String) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                try {
                    repository.getWeathers(lat, lon)
                } catch (e : Exception) {
                    e.message?.let {
                        onFail(it)
                    }?:onFail("알 수 없는 에러가 발생하였습니다.")
                }
            }

            val result = deferred.await()

            if(result is WeatherRepo) {
                if(result.cod == "200") {
                    onResult(result)
                } else {
                    onFail(result.message)
                }
            }
        }
    }
}