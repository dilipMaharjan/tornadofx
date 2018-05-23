package com.learn.view

import com.learn.controller.MyController
import javafx.scene.control.Alert
import tornadofx.*

class MainView : View("TornadoFX") {
    val myController: MyController by inject()

    override val root = vbox {
        label("Enter something") {
            onHover {
                alert(Alert.AlertType.INFORMATION, "Hover", "You hovered")
            }
        }


        val inputField = textfield()
        button("Ok") {
            action {
                val txt = inputField.text
                myController.writeToDb(txt)
                myController.values.add(txt)
                inputField.clear()
            }
        }

        label("List Items")
        listview(myController.values)
    }
}