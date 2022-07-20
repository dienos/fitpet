package jth.fitpet.data.model

import jth.fitpet.domain.model.WeatherRepo

data class WeatherRepoRes(private val _name : String) : WeatherRepo {
    override val name: String
        get() = _name
}