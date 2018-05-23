package com.learn.view

import com.learn.MyFragment.MyFragment
import javafx.stage.StageStyle
import tornadofx.*

class MainView : View("TornadoFX") {
    override val root = vbox {
        button("New Stage") {
            action {
                find(MyFragment::class).openModal(stageStyle = StageStyle.UTILITY)
            }
        }
        button("Current Root") {
            action {
                openInternalWindow(MyFragment::class)
            }
        }
        button("Another View") {
            action {
                replaceWith(AnotherView::class, ViewTransition.Slide(0.3.seconds, ViewTransition.Direction.RIGHT))
            }
        }
    }
}