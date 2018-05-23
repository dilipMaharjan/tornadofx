package com.learn.view

import com.learn.model.Person
import javafx.scene.control.SelectionMode
import javafx.scene.paint.Color
import tornadofx.*
import java.time.LocalDate

class MainView : View("TornadoFX") {

    private val greekLetters = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon").observable()

    private val persons = listOf(
        Person(1, "John", "Shrestha", LocalDate.of(1981, 12, 4)),
        Person(2, "Mathew", "Dangol", LocalDate.of(1989, 1, 24)),
        Person(3, "Mark", "Rai", LocalDate.of(2001, 2, 22)),
        Person(4, "http://i.imgur.com/DuFZ6PQb.jpg\\", "Rai", LocalDate.of(2010, 2, 22))
    ).observable()


    override val root = vbox {

        listview(greekLetters) {
            selectionModel.selectionMode = SelectionMode.MULTIPLE
        }

        tableview(persons) {
            readonlyColumn("ID", Person::id)
            readonlyColumn("First Name", Person::firstName)
            readonlyColumn("Last Name", Person::lastName)
            readonlyColumn("DOB", Person::dob)
            readonlyColumn("Age", Person::age).cellFormat {
                style {
                    text = if (it < 18) "Under Age" else it.toString()
                }
            }
        }
        datagrid(persons) {
            cellCache {
                stackpane {
                    circle(radius = 50.0) {
                        fill = Color.RED
                    }
                    if (it.firstName.startsWith("http")) {
                        imageview(it.firstName)
                    } else {
                        text(it.firstName)
                    }
                }

            }
        }
    }
}