package jp.katana.gui.controller

import javafx.scene.Scene
import javafx.scene.control.Alert
import javafx.scene.control.Button
import javafx.scene.control.ButtonType
import jp.katana.core.ServerState
import jp.katana.gui.view.MainView
import tornadofx.Controller
import tornadofx.alert

class ControlPanelViewController : Controller() {
    fun onClickStartButton(scene: Scene, button: Button, controller: ConsoleViewController) {
        button.isDisable = true
        runAsync {
            controller.clearLog()

            try {
                val mainView = find(MainView::class)
                mainView.controller.startServer()
                if (mainView.controller.server.state == ServerState.Running)
                    scene.lookup("#stopButton").isDisable = false
                else
                    button.isDisable = false
            } catch (e: Exception) {
                button.isDisable = false
            }
        }
    }

    fun onClickStopButton(scene: Scene, button: Button) {
        val alert = alert(
            Alert.AlertType.WARNING,
            "Warning",
            "Stop Server?",
            ButtonType.YES,
            ButtonType.NO
        )
        if (alert.result == ButtonType.YES) {
            button.isDisable = true
            runAsync {
                try {
                    val mainView = find(MainView::class)
                    mainView.controller.stopServer()
                    scene.lookup("#startButton").isDisable = false
                } catch (e: Exception) {
                    scene.lookup("#startButton").isDisable = false
                }
            }
        }
    }
}