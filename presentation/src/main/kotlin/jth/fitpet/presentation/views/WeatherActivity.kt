package jth.fitpet.presentation.views

import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import jth.fitpet.presentation.R
import jth.fitpet.presentation.databinding.WeatherActivityBinding
import jth.fitpet.presentation.viewmodels.WeatherViewModel

@AndroidEntryPoint
class WeatherActivity : BaseActivity<WeatherActivityBinding>() {
    private val _viewModel: WeatherViewModel by viewModels()
    private val viewModel : WeatherViewModel
    get() = _viewModel

    override fun getLayoutResId(): Int = R.layout.weather_activity

    override fun initializeViewModel() {
        binding?.viewModel = viewModel
        binding?.lifecycleOwner = this

        viewModel.getWeathers()
    }
}