package space.mrtuxa.bahnfreunde.events

import com.kotlindiscord.kord.extensions.components.components
import com.kotlindiscord.kord.extensions.components.publicButton
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import com.kotlindiscord.kord.extensions.utils.env
import dev.kord.common.entity.Snowflake
import space.mrtuxa.bahnfreunde.hafas.HaferClient

class VerifyDebugger : Extension() {
    override val name: String = "verify Debugger"

    override suspend fun setup() {
        publicSlashCommand() {
            name = "verify-debugger"
            description = "debug verify command"

            guild(Snowflake(env("GUILD_ID")))

            action {
                respond {
                    val station = HaferClient.stations().random()
                    content =
                        "Nenne mir einer der  nächsten  5 Abfahrten von ${station.name}\nDas kannst du via https://bahn.expert checken"
                    components {
                        publicButton(::VerificationForm) {
                            label = ":white_check_mark: Verify"
                            action {
                                val trainNumber = it?.trainNumber?.value ?: error("Missing input")

                                println(HaferClient.departure(station.id).departures.take(5))
                                if (trainNumber in HaferClient.departure(station.id).departures.take(50).map { it.line.fahrtNr }) {
                                    user.asMember(Snowflake(env("GUILD_ID"))).addRole(Snowflake(env("VERIFY_ROLE")))

                                    respond {
                                        content = "Du bist jetzt erfo   lgreich verifiziert"
                                    }
                                } else {
                                    respond {
                                        content = "Zugnummer ist falsch oder nicht vorhanden"
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}