package jth.fitpet.domain.model

interface WeatherRepo {
    val cod : String
    val message : String
    val cnt : Int
    val list : List<ListItem>
    val city : City
}