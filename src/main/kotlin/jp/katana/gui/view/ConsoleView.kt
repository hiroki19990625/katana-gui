package jp.katana.gui.view

import javafx.geometry.Insets
import javafx.scene.layout.Priority
import jp.katana.gui.controller.ConsoleViewController
import tornadofx.*

class ConsoleView : View("ConsoleView") {
    private val controller: ConsoleViewController by inject()

    override val root = vbox {
        label("Console") {
            vboxConstraints {
                margin = Insets(5.0, 10.0, 5.0, 5.0)
            }
        }
        textarea(controller.serverLog) {
            vboxConstraints {
                margin = Insets(0.0, 10.0, 10.0, 5.0)
            }
            vgrow = Priority.ALWAYS
            isEditable = false
        }
    }
}
