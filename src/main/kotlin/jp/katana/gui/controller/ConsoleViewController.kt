package jp.katana.gui.controller

import javafx.beans.property.SimpleStringProperty
import tornadofx.Controller

class ConsoleViewController : Controller() {
    val serverLog: SimpleStringProperty = SimpleStringProperty("")

    fun onServerStart() {
        clearLog()
    }

    fun onAddLog(line: String) {
        serverLog.value += "$line\n"
    }

    fun clearLog() {
        serverLog.value = ""
    }
}