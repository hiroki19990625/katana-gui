package jp.katana.gui.view

import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import jp.katana.core.ServerState
import jp.katana.gui.controller.MainViewController
import tornadofx.View
import tornadofx.alert
import tornadofx.borderpane


class MainView : View() {
    val controller: MainViewController by inject()

    override val root = borderpane {
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