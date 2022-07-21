package jth.fitpet.data.model

import com.google.gson.annotations.SerializedName
import jth.fitpet.domain.model.WeatherItem

data class WeatherItemRes(
    @SerializedName("id")
    val _id: Int,

    @SerializedName("main")
    val _main: String,

    @SerializedName("description")
    val _description: String,

    @SerializedName("icon")
    val _icon: String
) : WeatherItem {
    override val id: Int
        get() = _id
    override val description: String
        get() = _description
    override val icon: String
        get() = _icon
    override val main: String
        get() = _main
}