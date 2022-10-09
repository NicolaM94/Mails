import ui.views.LoginView
import tornadofx.*

class Engine :App(LoginView::class)

fun main() {
    launch<Engine>()
}