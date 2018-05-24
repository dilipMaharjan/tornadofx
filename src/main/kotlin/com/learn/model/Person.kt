package com.learn.model


/**
 * Created by Dilip Maharjan on 05/24/2018
 */

import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class Person(name: String? = null, title: String? = null) {
    val nameProperty = SimpleStringProperty(this, "name", name)
    var name by nameProperty

    val titleProperty = SimpleStringProperty(this, "title", title)
    var title by titleProperty
}