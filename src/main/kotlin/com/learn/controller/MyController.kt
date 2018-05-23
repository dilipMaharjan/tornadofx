package com.learn.controller

import javafx.collections.FXCollections
import tornadofx.*


/**
 * Created by Dilip Maharjan on 05/23/2018
 */
class MyController : Controller() {
    fun writeToDb(inputValue: String) {
        println(inputValue)
    }

    val values = FXCollections.observableArrayList("Alpha", "Beta", "Gamma", "Delta")
}