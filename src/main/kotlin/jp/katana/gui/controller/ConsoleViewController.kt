package jp.katana.gui.controller

import javafx.beans.property.SimpleStringProperty
import tornadofx.Controller

class ConsoleViewController : Controller() {
    val serverLog: SimpleStringProperty = SimpleStringProperty("")
    val input: SimpleStringProperty = SimpleStringProperty("")

    var invokeCommand: (String) -> Unit = {}

    fun onServerStart() {
        clearLog()
    }

    fun onAddLog(line: String) {
        serverLog.value += "$line\n"
    }

    fun clearLog() {
        serverLog.value = ""
    }

    fun inputEnter() {
        if (!input.value.isNullOrBlank()) {
            invokeCommand.invoke(input.value)
            input.value = ""
        }
    }
}