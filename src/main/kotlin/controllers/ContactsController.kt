package controllers

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import logic.Contact
import tornadofx.*
import java.io.File

class ContactsController :Controller() {

    var contacts :List<Contact>

    init {
        val gson = Gson()
        val typeToken = object :TypeToken<List<Contact>>() {}.type
        with(File("src/main/kotlin/contacts.json").readText()) {
            contacts = gson.fromJson(this,typeToken)
        }
        for (contact in contacts) {
            println(contact.mail)
        }
    }
}
