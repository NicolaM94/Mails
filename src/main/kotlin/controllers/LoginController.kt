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
        val reader = File("src/main/kotlin/logins.json").readText()
        val typeToken = object : TypeToken<List<LoginCredentials>>() {}.type
        credentials = gson.fromJson(reader,typeToken)
    }

    fun users () :List<String> {
        val userList :MutableList<String> = mutableListOf()
        for (c in credentials) {
            userList.add(c.username)
        }
        return userList
    }

    fun addCredentials (credentialsToAdd : LoginCredentials) {
        credentials.add(credentialsToAdd)
    }

    fun writeChanges () {
        val toWrite = gson.toJson(credentials)
        with(File("src/main/kotlin/logins.json")) {
            this.writeText(toWrite)
        }
    }
}

/**
 * Holds controller for the [LoginView]
 */
class LoginController :Controller() {

    var usernameHolder = SimpleStringProperty()
    var passwordHolder = SimpleStringProperty()
    var passwordRepetedHolder = SimpleStringProperty()
    val passwords = mutableListOf<String>()
    val loginManager = LoginManager


    /**Verifies if user is already taken*/
    fun verifyUsernameTaken():Boolean{
        return usernameHolder.value in LoginManager.users()
    }

    /** Verifies password match*/
    fun verifyPasswdMatch () :Boolean {
        return passwordHolder.value == passwordRepetedHolder.value
    }

    fun verifyPassword () :Boolean {
        for (c in LoginManager.credentials) {
            if (c.username == usernameHolder.value && c.password == passwordHolder.value) return true
        }
        return false
    }

    fun verifyUsername() :Boolean {
        return usernameHolder.value in LoginManager.users()
    }

    init {

    }


}
