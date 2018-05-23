package com.learn.view

import javafx.collections.FXCollections
import javafx.scene.control.TextField
import javafx.scene.paint.Color
import tornadofx.*
import java.time.LocalDate


class MainView : View("Create Account") {
    var firstName: TextField by singleAssign()
    var lastName: TextField by singleAssign()

    override val root = vbox {
        hbox {
            label("First name ")
            firstName = textfield {
                textProperty().addListener { obs, old, new ->
                    println("What $obs")
                    println("old $old")
                    println("new $new")
                }
            }
        }
        hbox {
            label("Last name ")
            lastName = textfield()
        }
        hbox {
            label("Gender")
            checkbox("Male") {
                action {
                    println(isSelected)
                }
            }
            checkbox("Female") {
                action {
                    println(isSelected)
                }
            }
        }
        hbox {
            label("DOB")
            datepicker {
                value = LocalDate.now()
            }
        }
        hbox {
            label("Introduction ")
            textarea()
        }
        hbox {
            label("States")
            combobox<String> {
                items = FXCollections.observableArrayList("FL", "MA", "CA")
            }
        }
        togglebutton {
            val stateText = selectedProperty().stringBinding {
                if (it == true) "ON" else "OFF"
            }
            textProperty().bind(stateText)
        }
        radiobutton("Already a user") {
            action {
                replaceWith(WelcomeView::class, ViewTransition.Slide(0.3.seconds, ViewTransition.Direction.UP))
            }
        }
        scrollpane {
            button("Create") {
                textFill = Color.BLUE
                action {
                    textFill = Color.RED
                    replaceWith(LoginView::class, ViewTransition.Slide(0.3.seconds, ViewTransition.Direction.UP))
                }
                useMaxWidth = true
                tooltip("Creates an account")
            }
        }
    }
}
