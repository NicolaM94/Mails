package ui.views

import controllers.MailController
import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import tornadofx.*

class MainView :View() {

    val controller :MailController by inject()

    override val root = borderpane {

        center = listview (controller.mailBase.asObservable()) {
            cellFormat {
                graphic = cache {
                    form {
                        fieldset (it.subject) {
                            field { label(it.body) }
                            field ("Recipients: ") { label (it.recipients.toString()) }
                            field ("Planned for: "){ label(it.plannedFor) }
                        }
                    }
                }
            }
        }

        right = vbox {

            style {
                borderColor += CssBox(Paint.valueOf("#000000"),Paint.valueOf("#000000"),Paint.valueOf("#000000"),Paint.valueOf("#000000"))
                alignment = Pos.TOP_CENTER
                baseColor = Color.ALICEBLUE
                spacing = Dimension(2.0,Dimension.LinearUnits.em)
                paddingAll = 50.0
            }

            button ("Simple mail") {action { replaceWith(SimpleMailView::class) }}
            button ("Programmed mail")
            button ("Settings") {
                action {
                    replaceWith(SettingsView::class)
                }
            }
            button ("Info") {
                action { replaceWith(AboutView::class) }
            }
            button ("Quit") {
                action { close() }
            }

        }
    }
}