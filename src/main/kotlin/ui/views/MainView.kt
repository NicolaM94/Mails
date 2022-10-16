package ui.views

import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import tornadofx.*

class MainView :View() {
    override val root = borderpane {

        center = hbox {
            style {
                borderColor += CssBox(Paint.valueOf("#000000"),Paint.valueOf("#000000"),Paint.valueOf("#000000"),Paint.valueOf("#000000"))
                baseColor = Color.YELLOW
            }
            text ("First Hbox"){  }
        }

        right = vbox {
            style {
                borderColor += CssBox(Paint.valueOf("#000000"),Paint.valueOf("#000000"),Paint.valueOf("#000000"),Paint.valueOf("#000000"))
                alignment = Pos.TOP_CENTER
                baseColor = Color.ALICEBLUE
                spacing = Dimension(2.0,Dimension.LinearUnits.em)
                paddingAll = 50.0
            }
            button ("Simple mail")
            button ("Programmed mail")
            button ("Settings")
            button ("Info")
            button ("Quit")
        }
    }
}