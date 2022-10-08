package ui.views

import tornadofx.*

class NewUserView :View() {
    override val root = form {
        fieldset ("New user") {
            field ("Username") { textfield () }
            field ("Password") { passwordfield() }
            field ("Re-type password") { passwordfield () }
        }
        button ("Create new user") {
            action { println("Hello");println("Hola") }
        }
        button ("Back") { action { replaceWith<LoginView>() } }
    }
}