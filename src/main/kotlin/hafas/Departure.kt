package space.mrtuxa.bahnfreunde.hafas

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable


@Serializable
data class Departure(val line: Line, val `when`: Instant?, val platform: String?) {
    @Serializable
    data class Line(val fahrtNr: String, val name: String)
}

@Serializable
data class Departures(val departures: List<Departure>)