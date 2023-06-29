package space.mrtuxa.bahnfreunde.events

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.int
import com.kotlindiscord.kord.extensions.commands.converters.impl.string
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.event
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import com.kotlindiscord.kord.extensions.utils.env
import dev.kord.common.entity.Snowflake
import dev.kord.core.behavior.interaction.respondEphemeral
import dev.kord.core.event.interaction.InteractionCreateEvent
import space.mrtuxa.bahnfreunde.hafas.HaferClient

class DepartureCommand : Extension() {
    override val name: String = "Departure Slash Command"

    override suspend fun setup() {
        publicSlashCommand(::departureArgs) {
            name = "departures"
            description = "Get departures from a specific station"

            allowByDefault = true

            guild(Snowflake(env("GUILD_ID")))

            action {
                val station = arguments.station.toString()



                respond {
                    content = "${HaferClient.stationName(station).name}\n ${HaferClient.departure(station).departures})}"
                }
            }
        }
    }
}

class departureArgs() : Arguments() {
    val station by int {
        name = "station"
        description = "station id"
    }
}