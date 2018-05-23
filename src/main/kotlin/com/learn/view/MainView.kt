package com.learn.view

import com.learn.css.MyStyle
import tornadofx.*

class MainView : View("Css") {
    override val root = hbox {
        addClass(MyStyle.vbox)
        label("Css")
        label("Css")
    }
}