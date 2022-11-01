package controllers

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleStringProperty
import logic.MailObject
import tornadofx.*
import java.io.File

class MailController :Controller() {

    //TODO: recipients key must be a list of strings, not a string. See mails.json file
    //TODO: add sign
    var mailBase = mutableListOf<MailObject>()

    //Mail fields
    val subject = SimpleStringProperty()
    val body = SimpleStringProperty()
    val attachments = SimpleListProperty<String>()

    val gson = Gson()

    init {
        val reader = File("src/main/kotlin/mails.json").readText()
        val token = object : TypeToken<List<MailObject>>() {}.type
        mailBase = gson.fromJson(reader,token)
        }

}

