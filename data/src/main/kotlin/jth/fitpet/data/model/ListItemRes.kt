package jth.fitpet.data.model

import com.google.gson.annotations.SerializedName
import jth.fitpet.domain.model.*

data class ListItemRes(
    @SerializedName("dt")
    val _dt: Long,

    @SerializedName("main")
    val _main: MainRes,

    @SerializedName("weather")
    val _weather: List<WeatherItemRes>,

    @SerializedName("clouds")
    val _clouds: CloudsRes,

    @SerializedName("pop")
    val _pop: Float,

    @SerializedName("dtText")
    val _dtText: String,

    @SerializedName("sys")
    val _sys: SysRes,

    @SerializedName("visibility")
    val _visibility: Int,

    @SerializedName("wind")
    val _wind: WindRes,
) : ListItem {
    override val dt: Long
        get() = _dt
    override val clouds: Clouds
        get() = _clouds
    override val pop: Float
        get() = _pop
    override val weather: List<WeatherItem>
        get() = _weather
    override val dtText: String
        get() = _dtText
    override val main: Main
        get() = _main
    override val sys: Sys
        get() = _sys
    override val visibility: Int
        get() = _visibility
    override val wind: Wind
        get() = _wind
}