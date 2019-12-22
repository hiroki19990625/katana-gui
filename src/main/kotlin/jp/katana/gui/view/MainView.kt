package jp.katana.gui.view

import javafx.scene.image.Image
import jp.katana.gui.controller.MainViewController
import tornadofx.View
import tornadofx.borderpane
import tornadofx.setStageIcon


class MainView : View() {
    val controller: MainViewController by inject()

    init {
        title = "katana-gui"
        setStageIcon(Image(this::class.java.classLoader.getResourceAsStream("katana-gui.png")))
    }

    override val root = borderpane {
        top<MenuBarView>()
        left<PlayerListView>()
        center<ConsoleView>()
        right<ControlPanelView>()
    }

    override fun onDock() {
        super.onDock()

        primaryStage.setOnCloseRequest {
            controller.onCloseRequest(it)
        }
    }
}