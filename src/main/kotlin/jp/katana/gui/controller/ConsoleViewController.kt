package jp.katana.gui.controller

import javafx.beans.property.SimpleStringProperty
import tornadofx.Controller

class ConsoleViewController : Controller() {
    val serverLog: SimpleStringProperty = SimpleStringProperty()

    fun onAddLog(line: String) {
        serverLog.value += "$line\n"
    }

    fun onClearLog() {
        serverLog.value = ""
    }

    fun onServerStop() {
        serverLog.value = ""
    }
}