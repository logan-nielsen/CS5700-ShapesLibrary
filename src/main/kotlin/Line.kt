package org.example

import kotlin.math.pow
import kotlin.math.sqrt

class Line(val point1: Point, val point2: Point): Shape() {
    init {
        val pointsEqual = point1.x == point2.x && point1.y == point2.y
        require(!pointsEqual) { "Points cannot have the same coordinates" }
    }

    fun getSlope(): Double {
        return (point2.y - point1.y) / (point2.x - point1.x)
    }

    fun getLength(): Double {
        return sqrt((point2.x - point1.x).pow(2.0) + (point2.y - point1.y).pow(2.0))
    }

    override fun move(xDelta: Double, yDelta: Double) {
        point1.move(xDelta, yDelta)
        point2.move(xDelta, yDelta)
    }
}