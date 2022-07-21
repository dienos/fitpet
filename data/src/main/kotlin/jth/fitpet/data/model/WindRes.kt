package jth.fitpet.data.model

import jth.fitpet.domain.model.Wind

data class WindRes(
    val _speed: Float,
    val _deg: Float,
    val _gust: Float
) : Wind {
    override val deg: Float
        get() = _deg
    override val gust: Float
        get() = _gust
    override val speed: Float
        get() = _speed
}