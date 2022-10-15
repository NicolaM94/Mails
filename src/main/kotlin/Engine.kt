import javafx.stage.Stage
import ui.views.LoginView
import tornadofx.*

class Engine :App(LoginView::class) {
    override fun start(stage: Stage) {
        with(stage) {
            this.isMaximized = true
        }
        super.start(stage)
    }
}

fun main() {
    launch<Engine>()
}