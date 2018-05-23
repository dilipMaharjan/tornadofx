package com.learn.view

import javafx.geometry.Orientation
import javafx.scene.control.Alert
import javafx.scene.control.TabPane
import javafx.scene.layout.Priority
import javafx.scene.paint.Color
import tornadofx.*

class MainView : View("TornadoFX") {
    override val root = vbox {

        button("Button 1").setOnAction {
            println("Button 1")
        }
        button("Button 2").setOnAction {
            println("Button 2")
        }

        hbox(2) {
            vboxConstraints {
                marginTop = 20.0
            }
            button("HGrow") {
                hgrow = Priority.ALWAYS
            }
            button("VGrow") {
                vgrow = Priority.ALWAYS
            }
        }
        flowpane {
            vboxConstraints {
                marginLeft = 10.0
                marginTop = 10.0
            }
            contextmenu {
                item("Send email").action {
                    println("Send email")
                }
                item("Change status") {
                    action {
                        println("Change Status")
                    }
                }
            }
            for (i in 1..100) {
                button(i.toString()) {
                    action {
                        alert(Alert.AlertType.INFORMATION, "Clicked item", "You clicked $i")
                    }
                }
            }
        }
        borderpane {
            top {
                label("Top")
                useMaxWidth = true
                style {
                    backgroundColor = multi(Color.PURPLE)
                }
            }
            right {
                label("Right")
                useMaxWidth = true
                style {
                    backgroundColor = multi(Color.GREEN)
                }
            }
            left {
                label("Left")
                useMaxWidth = true
                style {
                    backgroundColor = multi(Color.RED)
                }
            }
            bottom {
                label("Bottom")
                useMaxWidth = true
                style {
                    backgroundColor = multi(Color.YELLOW)
                }
            }
            center {
                form {
                    fieldset("Personal Info", labelPosition = Orientation.VERTICAL) {
                        field("First Name") {
                            textfield()
                        }
                        field("Last Name") {
                            textfield()
                        }
                        field("DOB") {
                            datepicker()
                        }
                    }
                    fieldset("Contact") {
                        field("Phone") {
                            textfield()
                        }
                        field("Email") {
                            textfield()
                        }
                    }
                    button("Submit") {
                        action {
                            alert(Alert.AlertType.CONFIRMATION, "Successful", "Successfully Submitted")
                        }
                    }
                }
            }
        }
        gridpane {
            row {
                button("North") {
                    useMaxWidth = true
                    gridpaneConstraints {
                        marginBottom = 10.0
                        columnSpan = 2
                    }
                }
            }
            row {
                button("West")
                button("East")
            }

            row {
                button("South") {
                    useMaxWidth = true
                    gridpaneConstraints {
                        marginTop = 10.0
                        columnSpan = 2
                    }
                }
            }

        }
        tabpane {
            tabClosingPolicy = TabPane.TabClosingPolicy.UNAVAILABLE
            tab("Screen 1") {
                hbox {
                    button("Button 1")
                    button("Button 2")
                }
            }
            tab("Screen 2") {
                vbox {
                    button("Button 3")
                    button("Button 4")
                }
            }
            tab("Screen 3") {
                listview(listOf(1, 2, 3, 4, 5).observable())
            }
        }
        menubar {
            menu("File") {
                menu("Connect") {
                    item("Facebook")
                    item("Instagram")
                }
                separator()
                item("Save", "Shortcut+S") {
                    action {
                        println("Saved")
                    }
                }
                item("Quit")
            }
            menu("Edit") {
                item("Copy")
                item("Paste")
            }
        }
        listmenu(theme = "blue", orientation = Orientation.HORIZONTAL) {
            item(text = "Projects") {
                activeItem = this
                whenSelected {
                    println("Projects")
                }
            }
            item(text = "Contacts") {
                whenSelected {
                    println("Contacts")
                }
            }
        }
        squeezebox {
            multiselect = false
            fold("Customer Editor", expanded = false) {
                form {
                    fieldset("Customer Details") {
                        field("Name") { textfield() }
                        field("Password") { textfield() }
                    }
                }
            }
            fold("Some other editor", expanded = true, closeable = true) {
                stackpane {
                    label("Nothing here")
                }
            }
        }
    }
}