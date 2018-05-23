package com.learn.view

import tornadofx.*

class MainView : View() {
    override val root = borderpane {
        top(TopView::class)
        bottom(BottomView::class)
    }
}
