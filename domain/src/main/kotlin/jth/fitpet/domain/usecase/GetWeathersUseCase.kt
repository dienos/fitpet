package jth.fitpet.domain.usecase

import jth.fitpet.domain.model.LocationData
import jth.fitpet.domain.model.WeatherRepo
import jth.fitpet.domain.repository.WeatherRepository
import kotlinx.coroutines.*
import java.lang.Exception

class GetWeathersUseCase(private val repository: WeatherRepository) {
    operator fun invoke(
        locations: ArrayList<LocationData>,
        scope: CoroutineScope,
        onResult: (List<WeatherRepo>) -> Unit = {},
        onFail: (String) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            try {
                val deferredList: ArrayList<Deferred<WeatherRepo>> = arrayListOf()

                locations.forEach { location ->
                    deferredList.add(async {
                        repository.getWeathers(
                            location.lat,
                            location.lon
                        )
                    })
                }

                onResult(deferredList.awaitAll())
            } catch (e: Exception) {
                e.message?.let {
                    onFail(it)
                } ?: onFail("알수 없는 에러 입니다.")
            }
        }
    }
}