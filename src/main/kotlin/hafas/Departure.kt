package space.mrtuxa.bahnfreunde.hafas

import kotlinx.serialization.Serializable

@Serializable
data class Departure(val line: Line) {
    @Serializable
    data class Line(val fahrtNr: String)
}

@Serializable
data class Departures(val departures: List<Departure>)