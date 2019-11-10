package jp.katana.gui.view

import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.scene.image.Image
import jp.katana.core.ServerState
import jp.katana.gui.controller.MainViewController
import tornadofx.View
import tornadofx.alert
import tornadofx.borderpane
import tornadofx.setStageIcon


class MainView : View() {
    val controller: MainViewController by inject()

    init {
        title = "katana-gui"
        setStageIcon(Image(this::class.java.classLoader.getResourceAsStream("katana-gui.png")))
    }

    override val root = borderpane {
        top<MenuBarView>()
        left<PlayerListView>()
        center<ConsoleView>()
        right<ControlPanelView>()
    }

    override fun onDock() {
        super.onDock()

        primaryStage.setOnCloseRequest {
            if (controller.server.state != ServerState.Stopped) {
                val alert = alert(
                    Alert.AlertType.WARNING,
                    "Warning",
                    "Stop Server?",
                    ButtonType.YES,
                    ButtonType.NO
                )
                if (alert.result == ButtonType.YES) {
                    runAsync {
                        controller.stopServer()
                    }
                } else {
                    it.consume()
                }
            }
        }
    }
}