package com.learn.view

import tornadofx.*


/**
 * Created by Dilip Maharjan on 05/23/2018
 */
class AnotherView : View("Another View") {
    override val root = vbox {
        button("Go to Main") {
            action {
                replaceWith(MainView::class, ViewTransition.Slide(0.3.seconds, ViewTransition.Direction.LEFT))
            }
        }
    }

    override fun onDock() {
        super.onDock()
        println("Docking")
    }

    override fun onUndock() {
        super.onUndock()
        println("UnDocking")
    }
}
