package jth.fitpet.domain.model

interface ListItem {
    val dt : Long
    val main : Main
    val weather : List<WeatherItem>
    val clouds : Clouds
    val wind : Wind
    val visibility : Int
    val pop : Float
    val sys : Sys
    val dtText : String
}
