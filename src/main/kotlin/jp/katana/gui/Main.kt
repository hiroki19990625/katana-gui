package jp.katana.gui

import org.apache.logging.log4j.core.config.plugins.util.PluginManager
import tornadofx.launch

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            PluginManager.addPackage("jp.katana.gui.utils")

            launch<Application>(args)
        }
    }
}