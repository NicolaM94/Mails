package ui.snippets

import javafx.scene.control.ContextMenu
import javafx.scene.control.ListView
import logic.Contact
import tornadofx.*

class ContactsContextMenu (val listView: ListView<Contact>, val selectedItem :Contact?, val sourceList :MutableList<Contact>) :ContextMenu() {

    init {
        item("Modify")
        item("Delete").action {
            utilities.removeContact(selectedItem!!,sourceList)
            listView.refresh()
        }
    }

}