package ui.views

import controllers.LoginController
import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import javafx.scene.text.FontWeight
import tornadofx.*

class LoginView :View (title = "MailS") {

    val loginController :LoginController by inject()

    fun verifyLogin () {
        when {
            !loginController.verifyUsername() -> openInternalWindow(ui.snippets.MissingUsername::class)
            !loginController.verifyPassword() -> openInternalWindow(ui.snippets.WrongPassword::class)
            else -> replaceWith<MainView>()
        }
    }

    override val root = vbox {
        style {
            backgroundColor += Paint.valueOf("#FFE184")
        }
        imageview (url = "Mails1.png") {
            fitHeight = 350.0
            fitWidth = 350.0
            paddingAll = 15
            isFillWidth = false
            alignment = Pos.CENTER
        }
        form {
            style {
                alignment = Pos.CENTER
            }
            fieldset ("Login") {
                field ("Username") { textfield (loginController.usernameHolder) }
                field ("Password") { passwordfield (loginController.passwordHolder) }
            }
        }
        vbox {
            style {
                paddingAll = 10
                alignment = Pos.CENTER
                spacing = Dimension(1.0,Dimension.LinearUnits.em)
            }
            button ("LogIn") {
                style {
                    fontWeight = FontWeight.BOLD
                    prefWidth = Dimension(15.0,Dimension.LinearUnits.em)
                }
                action {
                    verifyLogin()
                }
            }
            button ("New User") {
                action {
                    this@LoginView.replaceWith<NewUserView>()
                }
                style {
                    fontWeight = FontWeight.BOLD
                    prefWidth = Dimension(15.0,Dimension.LinearUnits.em)
                }
            }
            button ("About") {
                style {
                    prefWidth = Dimension(15.0,Dimension.LinearUnits.em)
                }
                action { replaceWith (AboutView::class)  }
            }
            button ("Quit") {
                action {close() }
                style {
                    prefWidth = Dimension(10.0,Dimension.LinearUnits.em)
                }
            }
        }
    }
}