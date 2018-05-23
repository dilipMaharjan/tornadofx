package com.learn.view

import javafx.scene.control.TextField
import tornadofx.*


class MainView : View("TornadoFX") {
    var firstName: TextField by singleAssign()
    var lastName: TextField by singleAssign()


    override val root = vbox {
        hbox {
            label("First name ")
            firstName = textfield()
        }
        hbox {
            label("Last name ")
            lastName = textfield()
        }
        button("Login") {
            action {
                println("Your fullname is ${firstName.text} ${lastName.text}")
            }
            useMaxWidth = true
        }
    }
}