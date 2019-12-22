package jp.katana.gui.controller

import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.stage.WindowEvent
import jp.katana.core.IServer
import jp.katana.core.ServerState
import jp.katana.server.Server
import tornadofx.Controller
import tornadofx.alert

class MainViewController : Controller() {
    var server: IServer = Server()
        private set

    fun startServer() {
        server = Server()
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