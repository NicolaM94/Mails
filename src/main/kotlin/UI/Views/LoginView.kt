package UI.Views

import javafx.geometry.Pos
import javafx.scene.text.FontWeight
import tornadofx.*

class LoginView :View (title = "MailS") {
    override val root = vbox {
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
                field ("Username") { textfield () }
                field ("Password") { passwordfield {  } }
            }
        }
        vbox {
            style {
                paddingAll = 10
                alignment = Pos.CENTER
                spacing = Dimension(1.0,Dimension.LinearUnits.em)
            }
            button ("Verify") {
                style {
                    fontWeight = FontWeight.BOLD
                    prefWidth = Dimension(15.0,Dimension.LinearUnits.em)
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
            button ("Quit") {
                action {close() }
                style {
                    fontWeight = FontWeight.BOLD
                    prefWidth = Dimension(10.0,Dimension.LinearUnits.em)
                }
            }
        }
    }
}