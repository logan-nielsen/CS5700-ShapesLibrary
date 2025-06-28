package org.example

open class Ellipse(val center: Point, val radius1: Double, val radius2: Double) : Shape2D() {
    init {
        require(radius1 > 0 && radius2 > 0) { "Radii must be greater than 0" }
    }

    override fun getArea(): Double {
        return Math.PI * radius1 * radius2
    }

    override fun doMove(xDelta: Double, yDelta: Double) {
        center.move(xDelta, yDelta)
    }
}