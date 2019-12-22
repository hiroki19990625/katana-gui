package jp.katana.gui.controller

import jp.katana.gui.view.KatanaServerInfoView
import tornadofx.Controller
import java.awt.Desktop
import java.io.File

class MenuBarViewController : Controller() {
    fun onOpenServerFolder() {
        Desktop.getDesktop().open(File("./"))
    }

    fun onOpenWorldFolder() {
        Desktop.getDesktop().open(File("worlds"))
    }

    fun onOpenLogFolder() {
        Desktop.getDesktop().open(File("logs"))
    }

    fun onOpenKatanaServerInfo() {
        val stage = find<KatanaServerInfoView>().openModal()
        stage!!.isResizable = false
    }
}