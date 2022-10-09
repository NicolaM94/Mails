import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import javax.json.Json
import kotlin.io.path.createTempDirectory

class LoginCredentials (val username:String,val password:String)

class LoginManager () {

    var credentials = mutableListOf<LoginCredentials>()

    init {
        val reader = File("src/main/kotlin/logins.json").readText()
        val gson = Gson()
        val typeToken = object : TypeToken<List<LoginCredentials>>() {}.type
        credentials = gson.fromJson<MutableList<LoginCredentials>>(reader,typeToken)
    }

    fun addCredentials (credentialsToAdd :LoginCredentials) {
        credentials.add(credentialsToAdd)
    }

}

fun main () {
    val loginManager = LoginManager()
    for (credential in loginManager.credentials) {
        println(credential.username)
        println(credential.password)
    }
}