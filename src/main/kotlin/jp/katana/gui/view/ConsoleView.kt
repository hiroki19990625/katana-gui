package jp.katana.gui.view

import javafx.geometry.Insets
import jp.katana.gui.controller.ConsoleViewController
import tornadofx.*

class ConsoleView : View("ConsoleView") {
    val controller: ConsoleViewController by inject()

    override val root = vbox {
        label("PlayerList") {
            vboxConstraints {
                margin = Insets(5.0, 10.0, 5.0, 5.0)
            }
        }
        textarea {
            vboxConstraints {
                margin = Insets(0.0, 10.0, 10.0, 5.0)
            }
            isDisable = true
        }
    }
}
