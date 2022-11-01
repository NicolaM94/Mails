package ui.views

import controllers.SettingsController
import javafx.scene.Parent
import tornadofx.*
import java.io.File

class SettingsView :View() {

    val controller : SettingsController by inject()

    override val root = vbox {

        style {
            spacing = Dimension(2.0,Dimension.LinearUnits.em)
            paddingAll = 15.0
        }

        form {
            fieldset ("Address settings") {
                field ("Sender address") { textfield(controller.senderAddress) }
                field ("Sender password") {passwordfield (controller.senderPassword) }
                field ("Sender SMTP server") { textfield (controller.senderServer) }
                field ("Sender SMTP port") { textfield(controller.senderPort) }
            }
            fieldset ("Mail settings") {
                field ("Default sign") { textfield(controller.defaultSign).promptText = "Copy HTML sign here" }
            }
        }
        button ("Save and exit") {
            action {
                with (File("src/main/kotlin/settings")) {
                    this.writeText(controller.senderAddress.value+"\n")
                    this.appendText(controller.senderPassword.value+"\n")
                    this.appendText(controller.senderServer.value+"\n")
                    this.appendText(controller.senderPort.value.toString() +"\n")
                };replaceWith(MainView::class)
            }
        }
        button ("Exit") {action { replaceWith(MainView::class) }}
    }


}