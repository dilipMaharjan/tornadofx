package com.learn.view

import javafx.scene.layout.BorderPane
import tornadofx.*

class MainView : View() {
    val topView: TopView by inject()
    val bottomView: BottomView by inject()

    override val root = BorderPane()

    init {
        with(root) {
            top = topView.root
            bottom = bottomView.root
        }
    }
}