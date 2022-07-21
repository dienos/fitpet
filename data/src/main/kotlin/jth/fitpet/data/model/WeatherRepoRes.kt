package jth.fitpet.data.model

import com.google.gson.annotations.SerializedName
import jth.fitpet.domain.model.City
import jth.fitpet.domain.model.ListItem
import jth.fitpet.domain.model.WeatherRepo

data class WeatherRepoRes(
    @SerializedName("city")
    val _city: CityRes,

    @SerializedName("cod")
    val _cod: String,

    @SerializedName("message")
    val _message: String,

    @SerializedName("cnt")
    val _cnt: Int,

    @SerializedName("list")
    val _list: List<ListItemRes>
) : WeatherRepo {
    override val city: City
        get() = _city

    override val cnt: Int
        get() = _cnt

    override val cod: String
        get() = _cod

    override val list: List<ListItem>
        get() = _list

    override val message: String
        get() = _message
}