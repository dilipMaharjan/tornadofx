package com.learn.view

import javafx.animation.Interpolator
import javafx.geometry.Insets
import javafx.scene.paint.Color
import javafx.scene.shape.ArcType
import javafx.util.Duration
import tornadofx.*

class MainView : View("TornadoFX") {
    override val root = stackpane {
        group {
            rectangle {
                fill = Color.BLUE
                width = 150.0
                height = 150.0
                arcWidth = 25.0
                arcHeight = 25.0
            }
            arc {
                centerX = 200.0
                centerY = 200.0
                radiusX = 50.0
                radiusY = 50.0
                startAngle = 45.0
                length = 250.0
                type = ArcType.ROUND
            }
        }
        circle {
            centerX = 100.0
            centerY = 100.0
            radius = 50.0
            fill = Color.RED
        }
        cubiccurve {
            startX = 0.0
            startY = 50.0
            controlX1 = 25.0
            controlY1 = 0.0
            controlX2 = 75.0
            controlY2 = 100.0
            endX = 150.0
            endY = 50.0
            fill = Color.GREEN
        }
        path {
            moveTo(0.0, 0.0)
            hlineTo(70.0)
            quadqurveTo {
                x = 120.0
                y = 60.0
                controlX = 100.0
                controlY = 0.0
            }
            lineTo(175.0, 55.0)
            arcTo {
                x = 50.0
                y = 50.0
                radiusX = 50.0
                radiusY = 50.0
            }
        }
        val rectangle = rectangle(width = 60.0, height = 40.0) {
            padding = Insets(20.0)
        }

        timeline {
            keyframe(Duration.seconds(5.0)) {
                keyvalue(rectangle.rotateProperty(), 90.0, interpolator = Interpolator.EASE_BOTH)
//                keyvalue(rectangle.scaleXProperty(), 5)
                keyvalue(rectangle.arcWidthProperty(), 60.0)
                keyvalue(rectangle.arcHeightProperty(), 60.0)
            }
            isAutoReverse = true
            cycleCount = 3
        }
    }
}