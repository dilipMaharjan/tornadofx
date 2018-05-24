package com.learn.model

import javafx.beans.property.SimpleStringProperty
import tornadofx.*


/**
 * Created by Dilip Maharjan on 05/24/2018
 */
class Person(name: String? = null, title: String? = null) {
    val nameProperty = SimpleStringProperty(this, "name", name)
    var name by nameProperty

    val titleProperty = SimpleStringProperty(this, "title", title)
    var title by titleProperty

}
