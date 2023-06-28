package space.mrtuxa.bahnfreunde

import com.kotlindiscord.kord.extensions.ExtensibleBot
import com.kotlindiscord.kord.extensions.utils.env
import space.mrtuxa.bahnfreunde.events.VerifyListener

suspend fun main() {
    val client = ExtensibleBot(env("TOKEN")) {
        presence {
            playing("Kord")
        }
        extensions {
            add(::VerifyListener)
        }
        kord {
            stackTraceRecovery = true
        }
    }
    client.start()
}