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
            item("Open World Folder") {
                action {
                    Desktop.getDesktop().open(File("worlds"))
                }
            }
            item("Open Log Folder") {
                action {
                    Desktop.getDesktop().open(File("logs"))
                }
            }
        }
        menu("Help") {
            item("Katana Server Info") {
                action {
                    val stage = find<KatanaServerInfoView>().openModal()
                    stage!!.isResizable = false
                }
            }
        }
    }
}
