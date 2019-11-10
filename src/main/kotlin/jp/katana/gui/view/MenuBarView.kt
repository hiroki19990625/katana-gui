package jp.katana.gui.view

import tornadofx.*
import java.awt.Desktop
import java.io.File

class MenuBarView : View("MenuBarView") {
    override val root = menubar {
        menu("File") {
            item("Open Server Folder") {
                action {
                    Desktop.getDesktop().open(File("./"))
                }
            }
        }
    }
}
