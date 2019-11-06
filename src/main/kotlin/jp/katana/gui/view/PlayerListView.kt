package jp.katana.gui.view

import javafx.geometry.Insets
import jp.katana.gui.controller.PlayerLIstViewController
import tornadofx.*

class PlayerListView : View("PlayerListView") {
    private val controller: PlayerLIstViewController by inject()

    override val root = vbox {
        label("PlayerList") {
            vboxConstraints {
                margin = Insets(5.0, 10.0, 5.0, 10.0)
            }
        }
        listview(controller.playerList) {
            vboxConstraints {
                margin = Insets(0.0, 10.0, 5.0, 10.0)
            }
        }
        label(controller.playerCountInfo) {
            vboxConstraints {
                margin = Insets(0.0, 10.0, 10.0, 10.0)
            }
        }
    }
}