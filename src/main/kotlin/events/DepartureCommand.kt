package space.mrtuxa.bahnfreunde.events

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.event
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.core.event.interaction.InteractionCreateEvent

class DepartureCommand : Extension() {
    override val name: String = "Departue Slash Command"

    override suspend fun setup() {
        publicSlashCommand {
            name = "departures"
            description = "Get departures from a specific station"



            action {

            }
        }
    }

}