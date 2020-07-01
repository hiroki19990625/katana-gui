package jp.katana.gui.view

import javafx.geometry.Insets
import jp.katana.gui.controller.ControlPanelViewController
import tornadofx.*

class ControlPanelView : View("ControlPanelView") {
    val controller: ControlPanelViewController by inject()

    private val consoleView: ConsoleView = find(ConsoleView::class)

    override val root = vbox {
        label("ControlPanel") {
            vboxConstraints {
                margin = Insets(5.0, 10.0, 5.0, 10.0)
            }
        }
        vbox {
            label("Server") {
                vboxConstraints {
                    margin = Insets(5.0, 10.0, 5.0, 10.0)
                }
            }
            hbox {
                button("Start") {
                    id = "startButton"
                    hboxConstraints {
                        marginRight = 10.0
                    }
                    style {
                        minWidth = 100.px
                    }
                    action {
                        controller.onClickStartButton(scene, this, consoleView.controller)
                    }
                }
                button("Stop") {
                    id = "stopButton"
                    isDisable = true
                    style {
                        minWidth = 100.px
                    }
                    action {
                        controller.onClickStopButton(scene, this)
                    }
                }
                vboxConstraints {
                    margin = Insets(10.0, 5.0, 10.0, 5.0)
                }
            }
            label("Console") {
                vboxConstraints {
                    margin = Insets(5.0, 10.0, 5.0, 10.0)
                }
            }
            button("ConsoleClear") {
                vboxConstraints {
                    margin = Insets(10.0, 10.0, 10.0, 10.0)
                }
                style {
                    minWidth = 200.px
                }
                action {
                    consoleView.controller.clearLog()
                }
            }
            style {
                borderColor += box(c("#000000"))
            }
            vboxConstraints {
                margin = Insets(0.0, 10.0, 0.0, 0.0)
            }
        }
    }
}
