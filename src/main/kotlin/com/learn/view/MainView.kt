package com.learn.view

import com.learn.model.Person
import com.learn.viewmodel.PersonViewModel
import javafx.scene.layout.BorderPane
import tornadofx.*

class MainView : View("Person Editor") {

    override val root = BorderPane()

    private val persons = listOf(Person("John", "Manager"), Person("Eric", "Managing Director")).observable()
    private val model = PersonViewModel(Person())

    init {

        with(root) {
            center {
                tableview(persons) {
                    column("Name", Person::nameProperty)
                    column("Title", Person::titleProperty)
                    model.rebindOnChange(this) { selectedPerson ->
                        person = selectedPerson ?: Person()
                    }
                }
            }
            right {
                form {
                    fieldset("Edit person") {
                        field("Name") {
                            textfield(model.name)
                        }
                        field("Title") {
                            textfield(model.title)
                        }
                        button("Save") {
                            enableWhen(model.dirty)
                            action {
                                save()
                            }
                        }
                        button("Reset").action {
                            model.rollback()
                        }
                    }
                }
            }
        }
    }

    private fun save() {
        model.commit()
        val person = model.person
        println("Saving ${person.name} / ${person.title}")
    }
}