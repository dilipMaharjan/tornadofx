package com.learn.app

import com.learn.css.MyStyle
import com.learn.view.MainView
import tornadofx.*

class MyApp : App(MainView::class, MyStyle::class) {
    init {
        reloadStylesheetsOnFocus()
    }
}