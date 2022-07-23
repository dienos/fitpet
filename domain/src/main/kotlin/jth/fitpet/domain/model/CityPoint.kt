package jth.fitpet.domain.model

enum class CityPoint(val cityName : String, val lat : Float, val lon : Float) {
    SEOUL("Seoul",37.5666805f, 126.9784147f),
    LONDON("London", 51.5072f,  -0.1275f),
    CHICAGO("Chicago",41.883853f, -87.631937f)
}