package jp.katana.gui.view

import javafx.geometry.Insets
import jp.katana.utils.GitCommitInfo
import tornadofx.*

class KatanaServerInfoView : View("KatanaServerInfo") {
    init {
    }

    override val root = vbox {
        label("Katana Server Info") {
            style {
                fontSize = 20.px
            }
            vboxConstraints {
                margin = Insets(10.0, 10.0, 0.0, 10.0)
            }
        }
        label("Branch: ${GitCommitInfo.branch}") {
            vboxConstraints {
                margin = Insets(10.0, 10.0, 10.0, 10.0)
            }
        }
        label("BuildUser: ${GitCommitInfo.buildUser}") {
            vboxConstraints {
                margin = Insets(10.0, 10.0, 10.0, 10.0)
            }
        }
        label("BuildVersion: ${GitCommitInfo.buildVersion}") {
            vboxConstraints {
                margin = Insets(10.0, 10.0, 10.0, 10.0)
            }
        }
        label("Message: ${GitCommitInfo.commitShortMessage}") {
            vboxConstraints {
                margin = Insets(10.0, 10.0, 10.0, 10.0)
            }
        }
        label("Id: ${GitCommitInfo.commitId}") {
            vboxConstraints {
                margin = Insets(10.0, 10.0, 10.0, 10.0)
            }
        }
        label("User: ${GitCommitInfo.commitUser}") {
            vboxConstraints {
                margin = Insets(10.0, 10.0, 10.0, 10.0)
            }
        }
        label("Time: ${GitCommitInfo.commitTime}") {
            vboxConstraints {
                margin = Insets(10.0, 10.0, 10.0, 10.0)
            }
        }
    }
}
