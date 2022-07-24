package jth.fitpet.presentation.views

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.ViewTreeObserver
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import jth.fitpet.presentation.R
import jth.fitpet.presentation.WeatherApplication.Companion.networkUtil
import jth.fitpet.presentation.utils.AnimationUtil
import jth.fitpet.presentation.utils.NetworkUtil
import jth.fitpet.presentation.viewmodels.SplashViewModel


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private val viewModel by viewModels<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkUtil = NetworkUtil(this)
        networkUtil.registerNetworkCallback()

        setContentView(R.layout.splash_activity)

        if(networkUtil.checkNetwork()) {
            val handler = Handler(mainLooper)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val content: View = findViewById(android.R.id.content)
                content.viewTreeObserver.addOnPreDrawListener(
                    object : ViewTreeObserver.OnPreDrawListener {
                        override fun onPreDraw(): Boolean {
                            return if (viewModel.complete.value) {
                                content.viewTreeObserver.removeOnPreDrawListener(this)
                                startActivity(Intent(this@SplashActivity, WeatherActivity::class.java))
                                finish()
                                true
                            } else {
                                false
                            }
                        }
                    }
                )

                handler.postDelayed({
                    viewModel.updateComplete()
                }, 500)
            } else {
                val aniUtil = AnimationUtil(this, R.drawable.avd_anim)
                aniUtil.playAnimation(findViewById(R.id.anim)) {
                    startActivity(Intent(this@SplashActivity, WeatherActivity::class.java))
                    finish()
                }
            }
        } else {
            networkUtil.networkNotConnect()
        }
    }
}