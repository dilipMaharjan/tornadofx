package com.learn.view

import com.learn.model.Person
import javafx.scene.control.TableView
import javafx.scene.control.TextField
import javafx.scene.layout.BorderPane
import tornadofx.*

class MainView : View("Person Editor") {

    override val root = BorderPane()

    private var nameField: TextField by singleAssign()
    private var titleField: TextField by singleAssign()
    private var personTable: TableView<Person> by singleAssign()

    private val persons = listOf(Person("John", "Manager"), Person("Jay", "Assistant Manager")).observable()
    private var prevSelection: Person? = null

    init {
        with(root) {
            center {
                tableview(persons) {
                    personTable = this
                    column("Name", Person::nameProperty)
                    column("Title", Person::titleProperty)

                    selectionModel.selectedItemProperty().onChange {
                        editPerson(it)
                        prevSelection = it
                    }
                }
            }
            bottom {
                form {
                    fieldset("Edit person") {
                        field("Name") {
                            textfield {
                                nameField = this
                            }
                        }
                        field("Title") {
                            textfield {
                                titleField = this
                            }
                        }
                        button("Save").action {
                            save()
                        }
                    }
                }
            }
        }
    }

    private fun editPerson(person: Person?) {
        if (person != null) {
            prevSelection?.apply {
                nameProperty.unbindBidirectional(nameField.textProperty())
                titleProperty.unbindBidirectional(titleField.textProperty())
            }
            nameField.bind(person.nameProperty)
            titleField.bind(person.titleProperty)
            prevSelection = person
        }
    }

    private fun save() {
        val person = personTable.selectedItem!!
        println("Saving ${person.name} / ${person.title}")
    }
}