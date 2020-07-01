package jp.katana.gui.controller

import javafx.application.Platform
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.stage.WindowEvent
import jp.katana.core.IServer
import jp.katana.core.ServerState
import jp.katana.gui.view.ConsoleView
import jp.katana.gui.view.ControlPanelView
import jp.katana.gui.view.PlayerListView
import jp.katana.server.Server
import jp.katana.server.event.server.ServerStartEvent
import jp.katana.server.event.server.ServerStopEvent
import tornadofx.Controller
import tornadofx.alert

class MainViewController : Controller() {
    var server: IServer = Server()
        private set

    fun startServer() {
        val tempServer = Server()
        tempServer.useGui = true
        server = tempServer

        val playerListView = find<PlayerListView>()
        val controlPanelView = find<ControlPanelView>()
        val consoleView = find<ConsoleView>()
        server.eventManager.getEvent(ServerStartEvent::class.java).plusAssign {
            Platform.runLater {
                playerListView.controller.onServerStart(server)
            }
        }
        server.eventManager.getEvent(ServerStopEvent::class.java).plusAssign {
            Platform.runLater {
                playerListView.controller.onServerStop()

                val scene = controlPanelView.root.scene
                scene.lookup("#startButton").isDisable = false
                scene.lookup("#stopButton").isDisable = true
            }
        }
        consoleView.controller.invokeCommand = {
            server.console.runCommand(it)
        }

        server.start()
    }

    fun stopServer() {
        server.shutdown()
    }

    fun onCloseRequest(ev: WindowEvent) {
        if (server.state != ServerState.Stopped) {
            val alert = alert(
                Alert.AlertType.WARNING,
                "Warning",
                "Stop Server?",
                ButtonType.YES,
                ButtonType.NO
            )
            if (alert.result == ButtonType.YES) {
                runAsync {
                    stopServer()
                }
            } else {
                ev.consume()
            }
        }
    }
}