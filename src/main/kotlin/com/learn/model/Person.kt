package com.learn.model

import java.time.LocalDate
import java.time.Period


/**
 * Created by Dilip Maharjan on 05/23/2018
 */
class Person(val id: Int, val firstName: String, val lastName: String, val dob: LocalDate) {
    val age: Int
        get() = Period.between(dob, LocalDate.now()).years
}