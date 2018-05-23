package com.learn.view

import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.NumberAxis
import tornadofx.*

class MainView : View("TornadoFX") {
    override val root = hbox {
        piechart("OS market share") {
            data("Windows", 77.62)
            data("OS X", 9.52)
            data("Other", 3.06)
            data("Linux", 1.55)
            data("Chrome OS", 0.55)
        }

        barchart("Unit Sales", CategoryAxis(), NumberAxis()) {
            series("Product X") {
                data("MAR", 10245)
                data("APR", 23963)
                data("MAY", 15038)
            }
            series("Product Y") {
                data("MAR", 28443)
                data("APR", 22845)
                data("MAY", 19045)
            }
        }
        linechart("Unit Sales Q2 2016", CategoryAxis(), NumberAxis()) {
            series("Product X") {
                data("MAR", 10245)
                data("APR", 23963)
                data("MAY", 15038)
            }
            series("Product Y") {
                data("MAR", 28443)
                data("APR", 22845)
                data("MAY", 19045)
            }
        }
        areachart("Area chart", CategoryAxis(), NumberAxis()) {
            series("Product X") {
                data("MAR", 10245)
                data("APR", 23963)
                data("MAY", 15038)
            }
            series("Product Y") {
                data("MAR", 28443)
                data("APR", 22845)
                data("MAY", 19045)
            }
        }
        scatterchart("Machine Capacity by Product/Week", NumberAxis(), NumberAxis()) {
            series("Product X") {
                data(1, 24)
                data(2, 22)
                data(3, 23)
                data(4, 19)
                data(5, 18)
            }
            series("Product Y") {
                data(1, 12)
                data(2, 15)
                data(3, 9)
                data(4, 11)
                data(5, 7)
            }
        }
        bubblechart("Machine Capacity by Output/Week", NumberAxis(), NumberAxis()) {
            series("Product X") {
                data(1, 24, 1)
                data(2, 46, 2)
                data(3, 23, 1)
                data(4, 27, 2)
                data(5, 18, 1)
            }
            series("Product Y") {
                data(1, 12, 1)
                data(2, 31, 2)
                data(3, 9, 1)
                data(4, 11, 1)
                data(5, 15, 2)
            }
        }
    }
}