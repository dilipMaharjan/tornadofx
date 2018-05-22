package com.learn.view

import com.learn.app.Styles
import tornadofx.*

class MainView : View("TornadoFX") {
    override val root = hbox {
        label(title) {
            addClass(Styles.heading)
        }
    }
}