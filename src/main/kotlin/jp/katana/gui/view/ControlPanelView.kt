package jp.katana.gui.view

import javafx.geometry.Insets
import javafx.scene.layout.Border
import javafx.scene.layout.BorderStroke
import tornadofx.*

class ControlPanelView : View("ControlPanelView") {
    override val root = vbox {
        label("ControlPanel") {
            vboxConstraints {
                margin = Insets(5.0, 10.0, 5.0, 10.0)
            }
        }
        hbox {
            button("Start") {
                hboxConstraints {
                    marginRight = 10.0
                }
            }
            button("Stop") {
                hboxConstraints {
                    marginRight = 10.0
                }
            }
            vboxConstraints {
                margin = Insets(10.0, 10.0, 10.0, 5.0)
            }
        }
    }
}
