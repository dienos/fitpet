package jth.fitpet.domain.model

interface City {
    val id: Int
    val name: String
    val coord: Coord
    val country : String
    val population : String
    val timezone : String
    val sunrise : Long
    val sunset : Long
}
