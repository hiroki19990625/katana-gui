package jp.katana.gui.view

import jp.katana.gui.controller.MenuBarViewController
import tornadofx.*
import java.awt.Desktop
import java.io.File

class MenuBarView : View("MenuBarView") {
    val controller: MenuBarViewController by inject()

    override val root = menubar {
        menu("File") {
            item("Open Server Folder") {
                action {
                    controller.onOpenServerFolder()
                }
            }
            item("Open World Folder") {
                action {
                    controller.onOpenWorldFolder()
                }
            }
            item("Open Log Folder") {
                action {
                    controller.onOpenLogFolder()
                }
            }
        }
        menu("Help") {
            item("Katana Server Info") {
                action {
                    controller.onOpenKatanaServerInfo();
                }
            }
        }
    }
}
