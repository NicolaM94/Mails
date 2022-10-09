package ui.views

import controllers.LoginController
import tornadofx.*

class NewUserView :View() {

    val controller :LoginController by inject()

    //TODO Continue from here, finish implementing the new user creation process
    fun verifyNewUser () {

    }

    override val root = form {
        fieldset ("New user") {
            field ("Username") { textfield () }
            field ("Password") { passwordfield() }
            field ("Re-type password") { passwordfield () }
        }
        button ("Create new user") {

        }
        button ("Back") { action { replaceWith<LoginView>() } }
    }
}