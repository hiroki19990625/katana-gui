package jp.katana.gui.view

import javafx.geometry.Insets
import tornadofx.*

class ControlPanelView : View("ControlPanelView") {
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
                        isDisable = true
                        runAsync {
                            val mainView = find(MainView::class)
                            mainView.controller.startServer()
                            scene.lookup("#stopButton").isDisable = false
                        }
                    }
                }
                button("Stop") {
                    id = "stopButton"
                    isDisable = true
                    style {
                        minWidth = 100.px
                    }
                    action {
                        isDisable = true
                        runAsync {
                            val mainView = find(MainView::class)
                            mainView.controller.stopServer()
                            scene.lookup("#startButton").isDisable = false
                        }
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
