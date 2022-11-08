package controllers

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javafx.collections.ObservableList
import logic.Contact
import tornadofx.*
import java.io.File

/**
 * Class controller for [ContactsView].
 * Holds references used as values in the view presented to the user.
 * @see ContactsView
 */
class ContactsController :Controller() {

    //Source loaded via init
    var contacts :MutableList<Contact>
    //Controller list used in ContactsView
    var observableContacts :ObservableList<Contact>

    init {
        //Populates contacts list
        val gson = Gson()
        val typeToken = object :TypeToken<MutableList<Contact>>() {}.type
        with(File("src/main/kotlin/contacts.json").readText()) {
            contacts = gson.fromJson(this,typeToken)
        }
        //Initialize observableContacts
        observableContacts = contacts.asObservable()
    }
}
