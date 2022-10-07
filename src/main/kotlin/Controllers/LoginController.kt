package Controllers

import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import java.security.MessageDigest
import java.sql.DriverManager

class LoginController :Controller() {

    var usernameHolder = SimpleStringProperty()
    var passwordHolder = SimpleStringProperty()
    var passwordRepetedHolder = SimpleStringProperty()
    val users = mutableListOf<String>()
    val passwords = mutableListOf<String>()



    /**Verifies if user is already taken*/
    fun verifyUsernameTaken():Boolean{
        return usernameHolder.value in users
    }

    /** Verifies password match*/
    fun verifyPasswdMatch () :Boolean {
        return passwordHolder.value == passwordRepetedHolder.value
    }

    /**Generate a hash sha256 from the password*/
    fun hashPassword(): ByteArray {
        //TODO: Non puoi mettere online il progetto con il salt in plain view qui. Scrivene uno random in un file e leggi quello piuttosto.
        val salt="ATw!st0fL3m0n"
        return MessageDigest.getInstance("SHA-256").digest((passwordHolder.value + salt).toByteArray())
    }

    init {

    }


}
