package jp.katana.gui.controller

import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import jp.katana.core.IServer
import jp.katana.core.actor.IActorPlayer
import tornadofx.Controller

class PlayerLIstViewController : Controller() {
    val playerList: ObservableList<String> = FXCollections.observableArrayList<String>()
    val playerCountInfo: SimpleStringProperty = SimpleStringProperty(createPlayerCountString(0, 0))

    fun onPlayerJoin(player: IActorPlayer, server: IServer) {
        playerList.add(player.displayName)
        playerCountInfo.value = createPlayerCountString(server.networkManager!!.getPlayers().size, server.maxPlayer)
    }

    fun onPlayerLeave(player: IActorPlayer, server: IServer) {
        playerList.remove(player.displayName)
        playerCountInfo.value = createPlayerCountString(server.networkManager!!.getPlayers().size, server.maxPlayer)
    }

    fun onServerStop() {
        playerList.clear()
        playerCountInfo.value = createPlayerCountString(0, 0)
    }

    private fun createPlayerCountString(now: Int, max: Int): String {
        return "Player: $now / $max"
    }
}