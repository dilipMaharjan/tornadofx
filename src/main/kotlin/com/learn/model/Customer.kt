package com.learn.model

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

/**
 * Created by Dilip Maharjan on 05/24/2018
 */
class Customer(id: Int, lastName: String, firstName: String) {


    val idProperty = SimpleIntegerProperty(this, "id", id)
    var id by idProperty

    val firstNameProperty = SimpleStringProperty(this, "firstName", firstName)

    val lastNameProperty = SimpleStringProperty(this, "lastName", lastName)
    var lastName by lastNameProperty


}