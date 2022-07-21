package jth.fitpet.data.model

import com.google.gson.annotations.SerializedName
import jth.fitpet.domain.model.Coord

data class CoordRes(
    @SerializedName("lon")
    val _lon: Float,

    @SerializedName("lat")
    val _lat: Float
) : Coord {
    override val lat: Float
        get() = _lon
    override val lon: Float
        get() = _lat
}