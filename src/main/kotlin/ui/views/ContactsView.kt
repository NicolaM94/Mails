package ui.views

import controllers.ContactsController
import tornadofx.*

class ContactsView :View() {

    //TODO Sistema qui, la grafica. Considera se tenere listview o no
    val controller : ContactsController by inject()

    override val root = vbox {
        listview (controller.contacts.asObservable()) {
            cellFormat {
                graphic = cache {
                    form {
                        style { spacing = Dimension(-1.0,Dimension.LinearUnits.em) }
                        fieldset ( it.lastname + it.name ) {
                            field (it.mail)
                        }
                    }
                }
            }
        }

        button ("Back") { action { replaceWith(MainView::class) } }

    }
}