package jth.fitpet.presentation.views

import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import jth.fitpet.presentation.R
import jth.fitpet.presentation.databinding.WeatherActivityBinding
import jth.fitpet.presentation.viewmodels.WeatherViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WeatherActivity : BaseActivity<WeatherActivityBinding>() {

    private lateinit var progress: WeatherLoading
    private val _viewModel: WeatherViewModel by viewModels()
    private val viewModel: WeatherViewModel
        get() = _viewModel

    override fun getLayoutResId(): Int = R.layout.weather_activity

    override fun initializeViewModel() {
        progress = WeatherLoading(this)
        binding?.viewModel = viewModel
        binding?.lifecycleOwner = this
        viewModel.getWeathers()
    }

    override fun initializeUiEvent() {
        binding?.lifecycleOwner?.lifecycleScope?.launch {
            viewModel.progressFlow.collect { isShowing ->

                if (isShowing) {
                    progress.show()
                } else {
                    progress.dismiss()
                }
            }

            viewModel.toastFlow.collect { text ->
                Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()
            }
        }
    }
}