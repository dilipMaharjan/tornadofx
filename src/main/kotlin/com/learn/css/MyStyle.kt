package com.learn.css


/**
 * Created by Dilip Maharjan on 05/23/2018
 */
import javafx.scene.paint.Color
import tornadofx.*

class MyStyle : Stylesheet() {
    companion object {
        val vbox by cssclass()
        private val topColor = Color.RED
        private val rightColor = Color.PURPLE
        private val leftColor = Color.ORANGE
        private val bottomColor = Color.BLUE
    }

    init {
        label {
            endMargin = 15.px
            textFill = Color.WHITE
            fontFamily = "Comic San MS"
            fontSize = 30.px
            borderColor += box(Color.WHITE)
            and(hover) {
                backgroundColor += Color.PURPLE
            }
        }
        vbox {
            padding = box(10.px)
            backgroundColor += Color.RED
            minWidth = 500.px
            minHeight = 500.px
        }
    }
}