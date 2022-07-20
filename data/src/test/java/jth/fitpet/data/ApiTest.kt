package jth.fitpet.data

import io.mockk.mockk
import jth.fitpet.data.api.WeatherService
import jth.fitpet.data.datasource.WeatherRemoteSourceImpl
import jth.fitpet.data.repository.WeatherRepositoryImpl
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

class ApiTest {
    private val userService = mockk<WeatherService>()
    private val userDataSource = WeatherRemoteSourceImpl(userService)
    private val userRepository = WeatherRepositoryImpl(userDataSource)

    @Test
    fun getWeathers() {
        runBlockingTest {
            userRepository.getWeathers("Seoul")
        }
    }
}