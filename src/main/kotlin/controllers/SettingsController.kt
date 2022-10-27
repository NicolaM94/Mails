package controllers

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import java.io.File

class SettingsController :Controller() {

    val senderAddress = SimpleStringProperty()
    val senderPassword = SimpleStringProperty()
    val senderServer = SimpleStringProperty()
    val senderPort = SimpleIntegerProperty()

    init {
        with(File("src/main/kotlin/settings")) {
            with(this.readLines()) {
                senderAddress.value = this[0]
                senderPassword.value = this[1]
                senderServer.value = this[2]
                senderPort.value = this[3].toInt()
            }
        }
    }

}