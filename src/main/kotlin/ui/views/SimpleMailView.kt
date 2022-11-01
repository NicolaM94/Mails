package ui.views

import controllers.MailController
import controllers.SettingsController
import javafx.scene.Parent
import tornadofx.*

class SimpleMailView :View() {

    val mailController :MailController by inject()
    val settingsController :SettingsController by inject()

    override val root = vbox {
        style {
            paddingAll = 10.0
            spacing = Dimension(2.0,Dimension.LinearUnits.em)
        }
        textfield { promptText = "Subject" }
        htmleditor {
            //TODO: Add sign
            htmlText = "<br><br>" + settingsController.defaultSign
        }
        hbox {
            button ("Add attachments")
        }
        hbox {
            button ("Back") { action { replaceWith(MainView::class) } }
        }
    }
}