package com.learn.view

import com.learn.controller.CustomerController
import com.learn.model.Customer
import tornadofx.*

class MainView : View("TornadoFX") {

    val controller: CustomerController by inject()

    var tableViewEditModel: TableViewEditModel<Customer> by singleAssign()

    override val root = borderpane {
        top = buttonbar {
            button("Commit").setOnAction {
                tableViewEditModel.commit()
            }
            button("ROLLBACK").setOnAction {
                tableViewEditModel.rollback()
            }
        }
        center = tableview<Customer> {
            items = controller.customers
            isEditable = true
            column("ID", Customer::idProperty)
            column("FIRST NAME", Customer::firstNameProperty).makeEditable()
            column("LAST NAME", Customer::lastNameProperty).makeEditable()
            enableCellEditing()
            enableDirtyTracking()
            tableViewEditModel = editModel
        }
    }
}

