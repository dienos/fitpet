package jth.fitpet.presentation.adapters

import android.widget.ExpandableListView
import androidx.databinding.BindingAdapter
import jth.fitpet.domain.model.WeatherRepo
import jth.fitpet.presentation.views.WeatherListAdapter

@BindingAdapter(value = ["weathers"])
fun setWeatherList(view: ExpandableListView, list: ArrayList<WeatherRepo>?) {
    list?.let {
        WeatherListAdapter(view.context, list).apply {
            view.setAdapter(this)
        }
    }
}