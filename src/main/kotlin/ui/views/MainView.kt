package ui.views

import tornadofx.*

class MainView :View() {
    override val root = hbox {
        hbox {

        }
        vbox {
            button ("Simple mail")
            button ("Programmed mail")
            button ("Settings")
            button ("Info")
            button ("Quit")
        }
    }
}