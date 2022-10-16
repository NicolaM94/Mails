package controllers

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import logic.MailObject
import tornadofx.*
import java.io.File

class MailController :Controller() {

    var mailBase = mutableListOf<MailObject>()
    val gson = Gson()

    init {
        val reader = File("src/main/kotlin/mails.json").readText()
        val token = object : TypeToken<List<MailObject>>() {}.type
        mailBase = gson.fromJson(reader,token)
        println(mailBase)
        }
}
