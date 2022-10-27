package ui.views

import javafx.geometry.Pos
import javafx.scene.Parent
import javafx.scene.text.TextAlignment
import org.w3c.dom.events.EventTarget
import tornadofx.*

val firstText = "MailS is a simple tool to send multiple mails to a client list.\nUse it in a form of newsletter platform or to automate answers."
val secondText = "Mails is licence-free and open source: feel free to modify the program and use it in whichever context you need to."
val thirdText = "MailS is entirely written in Kotlin, with the beautiful support of TornadoFx as wrapper for JavaFx libraries."
val fourthText = "If you like the project and find it useful, please consider donate something to support my job!"


class AboutView :View() {

    override val root = vbox {
        style {
            paddingAll = 10
            spacing = Dimension(1.0,Dimension.LinearUnits.em)
            alignment = Pos.TOP_CENTER
        }
        text(firstText).wrapIn(this)
        text(secondText).wrapIn(this)
        text(thirdText).wrapIn(this)
        text(fourthText).wrapIn(this)
        button ("Back to login") {
            action {replaceWith<LoginView>()}
        }
    }
}