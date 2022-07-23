package jth.fitpet.presentation.views

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.ViewTreeObserver
import android.view.animation.AnticipateInterpolator
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import jth.fitpet.presentation.R
import jth.fitpet.presentation.viewmodels.SplashViewModel

class SplashActivity : AppCompatActivity() {
    private val viewModel by viewModels<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    return if (viewModel.complete.value == true) {
                        content.viewTreeObserver.removeOnPreDrawListener(this)
                        startActivity( Intent(this@SplashActivity, WeatherActivity::class.java))
                        finish()
                        true
                    } else {
                        false
                    }
                }
            }
        )

        Handler(mainLooper).postDelayed({
            viewModel.updateComplete()
        },500)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            splashScreen.setOnExitAnimationListener { splashScreenView ->
                // Create your custom animation.
                val slideUp = ObjectAnimator.ofFloat(
                    splashScreenView,
                    View.TRANSLATION_Y,
                    0f,
                    -splashScreenView.height.toFloat()
                )
                slideUp.interpolator = AnticipateInterpolator()
                slideUp.duration = 500L

                slideUp.doOnEnd {
                    splashScreenView.remove()
                }

                slideUp.start()
            }
        } else {
            startActivity( Intent(this@SplashActivity, WeatherActivity::class.java))
            finish()
        }
    }
}