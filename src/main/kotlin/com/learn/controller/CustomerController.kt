package com.learn.controller

import com.learn.model.Customer
import tornadofx.*


/**
 * Created by Dilip Maharjan on 05/24/2018
 */
class CustomerController : Controller() {
    val customers = listOf(
        Customer(1, "Marley", "John"),
        Customer(2, "Schmidt", "Ally"),
        Customer(3, "Johnson", "Eric")
    ).observable()
}