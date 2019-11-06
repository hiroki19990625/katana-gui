package jp.katana.gui.view

import tornadofx.View
import tornadofx.borderpane


class MainView : View() {
    override val root = borderpane {
        left<PlayerListView>()
        center<ConsoleView>()
    }
}