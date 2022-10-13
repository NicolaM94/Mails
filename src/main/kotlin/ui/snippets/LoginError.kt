package ui.snippets

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

class PasswordEmpty :View (title = title) {
    override val root = hbox {
        text ("Can't leave the password field empty!")
    }
}

class MissingUsername :View (title = title) {
    override val root = hbox {
        text ("Username not found!")
    }
}

class KeygenVerification :View (title = title) {
    override val root = hbox {
        text ("Invalid user creation key!")
    }
}