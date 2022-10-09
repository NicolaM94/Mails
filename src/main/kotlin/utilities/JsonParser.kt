package utilities

import com.google.gson.Gson
import java.io.File

fun main() {
    val gson = Gson()
    val reader = File("logins.json").reader()
    println(gson.toJson(reader))
}