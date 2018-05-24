package com.learn.viewmodel

import com.learn.model.Person
import tornadofx.*


/**
 * Created by Dilip Maharjan on 05/24/2018
 */

class PersonViewModel(var person: Person) : ViewModel() {
    val name = bind { person.nameProperty }
    val title = bind { person.titleProperty }
}