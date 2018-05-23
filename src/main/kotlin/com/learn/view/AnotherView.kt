package com.learn.view

import tornadofx.*


/**
 * Created by Dilip Maharjan on 05/23/2018
 */
class AnotherView : View("Another View") {
    override val root = vbox {
        button("Go to Main") {
            action {
                replaceWith(MainView::class)
            }
        }
    }
}
