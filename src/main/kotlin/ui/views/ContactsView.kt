package ui.views

import controllers.ContactsController
import javafx.beans.Observable
import javafx.collections.ObservableList
import logic.Contact
import tornadofx.*
import ui.snippets.ContactsContextMenu

class ContactsView :View() {

    //TODO Sistema qui, la grafica. Considera se tenere listview o no
    val controller : ContactsController by inject()

    override val root = borderpane {
        center = listview (controller.observableContacts) {
            cellFormat {
                graphic = cache {
                    form {
                        style { spacing = Dimension(-1.0, Dimension.LinearUnits.em) }
                        fieldset(it.lastname + it.name) {
                            field(it.mail)
                            //TODO: Fix contextmenu, revert to implementation here
                            ContactsContextMenu(this@listview, selectedItem, controller.observableContacts)
                        }
                    }
                }
            }
        }

        bottom = hbox {
            button ("New contact")
            button ("Modify selected")
            button ("Delete selected")
            button ("Back") { action { replaceWith(MainView::class) } }
        }

    }
}