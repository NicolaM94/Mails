package utilities

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
class LoginCreadentials (userName: String, password: String)

class CredentialParsers () {

    fun parse () {
        val input = File("src/main/kotlin/logins.json").reader()

    }
}

fun main () {
    println(CredentialParsers().parse().toString())
}