package ui.views

import controllers.MailController
import controllers.SettingsController
import javafx.scene.Parent
import javafx.scene.paint.Color
import tornadofx.*

class SimpleMailView :View() {

    val mailController :MailController by inject()
    val settingsController :SettingsController by inject()

    override val root = vbox {
        style {
            baseColor = Color.web("#c1d3ff")
            paddingAll = 10.0
            spacing = Dimension(2.0,Dimension.LinearUnits.em)
        }
        textfield (mailController.subject){ promptText = "Subject" }
        htmleditor {
            //TODO: Add sign
            htmlText = mailController.body.value + "<br><br>" + settingsController.defaultSign
        }
        hbox {
            style {
                spacing = Dimension(1.0,Dimension.LinearUnits.em)
            }
            button ("Add attachments") {
                style {
                    baseColor = Color.web("#2e2be2")
                }
            }
            button ("Add recipients") {
                style {
                    baseColor = Color.web("#2e2be2")
                }
            }
        }
        hbox {
            button ("Back") {
                style { baseColor = Color.web("#2e2be2") }
                action { replaceWith(MainView::class) }
            }
        }
    }
}