package jth.fitpet.data.model

import com.google.gson.annotations.SerializedName
import jth.fitpet.domain.model.Sys

data class SysRes(
    @SerializedName("pod")
    val _pod: String
) : Sys {
    override val pod: String
        get() = _pod
}