package controllers

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javafx.beans.property.SimpleStringProperty
import logic.LoginCredentials
import tornadofx.*
import java.io.File
import java.security.MessageDigest

/**
 * Reads and parse the logins.json file and adds some utilities to manage credentials.
 * @see LoginView
 */
object LoginManager {

    val gson = Gson()
    var credentials = mutableListOf<LoginCredentials>()

    init {
        //Reads src file and collects json objects to populate credentials
        val reader = File("src/main/kotlin/logins.json").readText()
        val typeToken = object : TypeToken<List<LoginCredentials>>() {}.type
        credentials = gson.fromJson(reader,typeToken)
    }

    //Returns the list of users names. Used in fun verifyUsername and fun verifyUsernameTaken in LoginController
    fun users () :List<String> {
        val userList :MutableList<String> = mutableListOf()
        for (c in credentials) {
            userList.add(c.username)
        }
        return userList
    }

    //Adds a new user to the user pool var credentials. Used in verifyNewUser
    fun addCredentials (credentialsToAdd : LoginCredentials) {
        credentials.add(credentialsToAdd)
    }

    //Actually writes down new user to the src json file. Used in verifyNewUser
    fun writeChanges () {
        val toWrite = gson.toJson(credentials)
        with(File("src/main/kotlin/logins.json")) {
            this.writeText(toWrite)
        }
    }
}

/**
 * Class controller for [LoginView].
 * Holds references used as values in the view presented to the user.
 * Collects data from [LoginManager]
 * @see LoginView
 */
class LoginController :Controller() {

    //Keygen used as privileged user validation to create new users
    val keygen = "1234567890"

    //String properties placeholders for the view
    var usernameHolder = SimpleStringProperty()
    var passwordHolder = SimpleStringProperty()
    var passwordRepetedHolder = SimpleStringProperty()
    var keygenHolder = SimpleStringProperty()

    //Verifies username taken in VerifyNewUser
    fun verifyUsernameTaken():Boolean{
        return usernameHolder.value in LoginManager.users()
    }

    // Verifies password match in VerifyNewUser
    fun verifyPasswdMatch () :Boolean {
        return passwordHolder.value == passwordRepetedHolder.value
    }

    //Verifies password math used in VerifyLogin
    fun verifyPassword () :Boolean {
        for (c in LoginManager.credentials) {
            if (c.username == usernameHolder.value && c.password == passwordHolder.value) return true
        }
        return false
    }

    //Verifies if username is in the users used in VerifyNewUser
    fun verifyUsername() :Boolean {
        return usernameHolder.value in LoginManager.users()
    }

    //Verifies keygen right
    fun verifyKeygen () :Boolean {
        return keygen == keygenHolder.value
    }
}
