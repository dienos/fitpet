package jth.fitpet.data.model

import com.google.gson.annotations.SerializedName
import jth.fitpet.domain.model.City
import jth.fitpet.domain.model.Coord

data class CityRes(
    @SerializedName("id")
    val _id: Int,

    @SerializedName("name")
    val _name: String,

    @SerializedName("coord")
    val _coord: CoordRes,

    @SerializedName("country")
    val _country: String,

    @SerializedName("population")
    val _population: String,

    @SerializedName("timezone")
    val _timezone: String,

    @SerializedName("sunrise")
    val _sunrise: Long,

    @SerializedName("sunset")
    val _sunset: Long,
) : City {
    override val id: Int
        get() = _id
    override val name: String
        get() = _name
    override val coord: Coord
        get() = _coord
    override val country: String
        get() = _country
    override val population: String
        get() = _population
    override val timezone: String
        get() = _timezone
    override val sunrise: Long
        get() = _sunrise
    override val sunset: Long
        get() = _sunset
}