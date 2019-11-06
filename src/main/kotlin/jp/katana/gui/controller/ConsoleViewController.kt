package jp.katana.gui.controller

import javafx.beans.property.SimpleStringProperty
import tornadofx.Controller

class ConsoleViewController : Controller() {
    val serverLog: SimpleStringProperty = SimpleStringProperty()
    
    fun onServerStart() {
        serverLog.value = ""
    }

    fun onAddLog(line: String) {
        serverLog.value += "$line\n"
    }

    fun onClearLog() {
        serverLog.value = ""
    }
}