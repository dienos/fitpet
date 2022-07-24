package jth.fitpet.presentation.utils

import android.content.Context
import android.net.*
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import jth.fitpet.presentation.R
import jth.fitpet.presentation.views.WeatherDialogFragment

class NetworkUtil constructor(val context: Context?) {
    private val networkCallBack = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {

        }

        override fun onLost(network: Network) {
            Toast.makeText(context, R.string.network_error, Toast.LENGTH_SHORT).show()
        }
    }

    fun checkNetwork() : Boolean {
        val connectivityManager = context?.getSystemService(ConnectivityManager::class.java)

        connectivityManager?.activeNetworkInfo?.let {
            return it.isConnectedOrConnecting
        } ?: return false
    }

    fun registerNetworkCallback() {
        val connectivityManager = context?.getSystemService(ConnectivityManager::class.java)
        val networkRequest = NetworkRequest.Builder()
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .build()
        connectivityManager?.registerNetworkCallback(networkRequest, networkCallBack)
    }

    fun terminateNetworkCallback() {
        val connectivityManager = context?.getSystemService(ConnectivityManager::class.java)
        connectivityManager?.unregisterNetworkCallback(networkCallBack)
    }

    fun networkNotConnect() {
        if(context is FragmentActivity) {
            val fragmentManager: FragmentManager = context.supportFragmentManager

            if (fragmentManager.isDestroyed.not()) {
                WeatherDialogFragment(context.getString(R.string.network_error)) {
                    context.finish()
                }.show(context.supportFragmentManager, "Custom")
            }
        }
    }
}