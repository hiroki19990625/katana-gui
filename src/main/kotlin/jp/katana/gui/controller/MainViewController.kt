package jp.katana.gui.controller

import jp.katana.core.IServer
import jp.katana.server.Server
import tornadofx.Controller

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
}