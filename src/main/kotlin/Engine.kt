import javafx.stage.Stage
import ui.views.LoginView
import tornadofx.*

class Engine :App(LoginView::class) {
    override fun start(stage: Stage) {
        with(stage) {
            this.width = 1366.0
            this.height = 780.0
        }
        super.start(stage)
    }
}

fun main() {
    launch<Engine>()
}