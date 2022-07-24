package jth.fitpet.presentation

import android.annotation.SuppressLint
import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import jth.fitpet.presentation.utils.NetworkUtil

@HiltAndroidApp
class WeatherApplication : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var networkUtil : NetworkUtil
    }

    override fun onCreate() {
        super.onCreate()
        networkUtil = NetworkUtil(this)
        networkUtil.registerNetworkCallback()
    }
}