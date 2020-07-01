package jp.katana.gui.view

import javafx.geometry.Insets
import javafx.scene.input.KeyCode
import javafx.scene.layout.Priority
import jp.katana.gui.controller.ConsoleViewController
import jp.katana.gui.utils.TextAreaAppender
import tornadofx.*

class ConsoleView : View("ConsoleView") {
    val controller: ConsoleViewController by inject()

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
            TextAreaAppender.setTextArea(this)
        }
        textfield(controller.input) {
            vboxConstraints {
                margin = Insets(0.0, 10.0, 10.0, 5.0)
            }
            vgrow = Priority.ALWAYS
            setOnKeyPressed {
                if (it.code == KeyCode.ENTER) {
                    controller.inputEnter()
                }
            }
        }
    }
}
