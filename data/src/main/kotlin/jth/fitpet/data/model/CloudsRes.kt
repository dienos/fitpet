package jth.fitpet.data.model

import com.google.gson.annotations.SerializedName
import jth.fitpet.domain.model.Clouds

data class CloudsRes(
    @SerializedName("all")
    val _all: Int
) : Clouds {
    override val all: Int
        get() = _all
}