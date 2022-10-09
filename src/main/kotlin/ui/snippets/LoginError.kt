package ui.snippets

import javafx.scene.Parent
import tornadofx.*

val title = "Login error"

class PasswordMismatch :View (title = title ) {
    override val root = hbox {
        text ("Password mismatch!")
    }
}

class UsernameAlreadyTaken :View (title = title) {
    override val root = hbox {
        text ("Username already taken!")
    }
}

class WrongPassword :View (title = title) {
    override val root = hbox {
        text ("Wrong password!")
    }
}

class MissingUsername :View (title = title) {
    override val root = hbox {
        text ("Username not found!")
    }
}