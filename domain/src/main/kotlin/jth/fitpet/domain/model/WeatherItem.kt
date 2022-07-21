package jth.fitpet.domain.model

interface WeatherItem {
    val id : Int
    val main : String
    val description : String
    val icon : String
}