package jth.fitpet.data.model

import com.google.gson.annotations.SerializedName
import jth.fitpet.domain.model.Main

data class MainRes(
    @SerializedName("temp")
    val _temp: Float,

    @SerializedName("feels_like")
    val _feelsLike: Float,

    @SerializedName("temp_min")
    val _tempMin: Float,

    @SerializedName("temp_max")
    val _tempMax: Float,

    @SerializedName("pressure")
    val _pressure: Float,

    @SerializedName("sea_level")
    val _seaLevel: Float,

    @SerializedName("grnd_level")
    val _grandLevel: Float,

    @SerializedName("humidity")
    val _humidity: Float,

    @SerializedName("temp_kf")
    val _tempKf: Float,
) : Main {
    override val grandLevel: Float
        get() = _grandLevel
    override val feelsLike: Float
        get() = _feelsLike
    override val humidity: Float
        get() = _humidity
    override val pressure: Float
        get() = _pressure
    override val seaLevel: Float
        get() = _seaLevel
    override val temp: Float
        get() = _temp
    override val tempKf: Float
        get() = _tempKf
    override val tempMax: Float
        get() = _tempMax
    override val tempMin: Float
        get() = _tempMin
}