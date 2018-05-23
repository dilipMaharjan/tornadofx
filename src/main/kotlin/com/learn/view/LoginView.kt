package com.learn.view

import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import tornadofx.*


/**
 * Created by Dilip Maharjan on 05/23/2018
 */
class LoginView : View("My View") {

    private var usernameField: TextField by singleAssign()
    private var passwordField: PasswordField by singleAssign()

    override val root = vbox {

        hbox {
            label("Enter username")
            usernameField = textfield()
        }

        hbox {
            label("Enter password")
            passwordField = passwordfield {
                requestFocus()
            }
        }

        button("Login") {
            action {
                replaceWith(WelcomeView::class, ViewTransition.Slide(0.3.seconds, ViewTransition.Direction.UP))
            }
            useMaxWidth = true
        }

    }
}
