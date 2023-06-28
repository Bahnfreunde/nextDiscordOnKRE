package space.mrtuxa.bahnfreunde.hafas

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

object HaferClient {
    private val client = HttpClient {
        install(ContentNegotiation) {
            val jason = Json {
                ignoreUnknownKeys = true
            }

            json(jason)
        }
        defaultRequest {
            url.takeFrom("https://v6.db.transport.rest/")
        }
    }

    suspend fun stations(): Collection<Station> {
        return client.get("stations").body<Map<String, Station>>().values
    }

    suspend fun departure(id: String): Departures {
        return client.get("stops/$id/departures").body<Departures>()
    }
}