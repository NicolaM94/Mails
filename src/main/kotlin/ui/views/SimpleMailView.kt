package ui.views

import javafx.scene.Parent
import tornadofx.*

class SimpleMailView :View() {

    override val root = vbox {
        style {
            paddingAll = 10.0
            spacing = Dimension(2.0,Dimension.LinearUnits.em)
        }
        textfield { promptText = "Subject" }
        htmleditor {
            //TODO: Add sign
            htmlText = "<br><br><h1>Ciao</h1>"
        }
        hbox {
            button ("Add attachments")
        }
        hbox {
            button ("Back") { action { replaceWith(MainView::class) } }
        }
    }
}