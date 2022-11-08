package ui.views

import controllers.LoginController
import controllers.LoginManager
import logic.LoginCredentials
import tornadofx.*
import ui.snippets.KeygenVerification
import ui.snippets.PasswordMismatch
import ui.snippets.UsernameAlreadyTaken

class NewUserView :View() {

    val controller :LoginController by inject()

    //TODO Continue from here, finish implementing the new user creation process
    fun verifyNewUser () :Boolean {
        when {
            controller.verifyUsernameTaken() -> {
                openInternalWindow(UsernameAlreadyTaken::class)
                return false
            }
            !controller.verifyPasswdMatch() -> {
                openInternalWindow(PasswordMismatch::class)
                return false
            }
            !controller.verifyKeygen() -> {
                openInternalWindow(KeygenVerification::class)
                return false
            }
            else -> {
                println("Checks passed")
                println("Writing changes...")
                LoginManager.addCredentials(LoginCredentials(
                    controller.usernameHolder.value,
                    controller.passwordHolder.value
                ))
                LoginManager.writeChanges()
                replaceWith(LoginView::class)
            }
        }
        return true
    }

    override val root = form {
        fieldset ("New user") {
            field ("Username") { textfield (controller.usernameHolder) }
            field ("Password") { passwordfield (controller.passwordHolder) }
            field ("Re-type password") { passwordfield (controller.passwordRepetedHolder) }
            field ("Creator keygen") {passwordfield(controller.keygenHolder)}
        }
        button ("Create new user") {
            action { verifyNewUser() }
        }
        button ("Back") { action { replaceWith<LoginView>() } }
    }
}