package jth.fitpet.presentation.adapters

import android.widget.ExpandableListView
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import jth.fitpet.domain.model.WeatherRepo
import jth.fitpet.presentation.R
import jth.fitpet.presentation.utils.DateUtil
import jth.fitpet.presentation.views.WeatherListAdapter
import java.util.*

@BindingAdapter(value = ["weathers"])
fun setWeatherList(view: ExpandableListView, list: List<WeatherRepo>?) {
    list?.let {
        WeatherListAdapter(view.context, list).apply {
            view.setAdapter(this)

            if (groupCount > 0) {
                for (i in 0 until groupCount) {
                    view.expandGroup(i)
                }
            }
        }
    }
}

@BindingAdapter(value = ["dayString"])
fun setDayString(view: TextView, dateString: String?) {
    dateString?.let {
        val dayString = when (DateUtil.differenceDays(it)) {
            0 -> {
                view.context.getString(R.string.today).plus(" ").plus(
                    DateUtil.convertDateStringFormat(
                        it,
                        DateUtil.HOUR_MIN_FORMAT,
                        Locale("en")
                    )
                )
            }

            1 -> {
                view.context.getString(R.string.tomorrow).plus(" ").plus(
                    DateUtil.convertDateStringFormat(
                        it,
                        DateUtil.HOUR_MIN_FORMAT,
                        Locale("en")
                    )
                )
            }

            else -> {
                DateUtil.convertDateStringFormat(it, DateUtil.NEW_WEATHER_DATE_FORMAT, Locale("en"))
            }
        }

        view.text = dayString
    }
}

@BindingAdapter(value = ["weather_img"])
fun setWeatherImage(view: ImageView, icon: String) {
    val url = "http://openweathermap.org/img/w/".plus(icon).plus(".png")
    Glide.with(view.context).load(url).into(view)
}

@BindingAdapter(value = ["min_temp"])
fun setMinTempString(view: TextView, temp: Float) {
    view.text = view.context.getString(R.string.min_temp, temp.toString())
}

@BindingAdapter(value = ["max_temp"])
fun setMaxTempString(view: TextView, temp: Float) {
    view.text = view.context.getString(R.string.max_temp, temp.toString())
}