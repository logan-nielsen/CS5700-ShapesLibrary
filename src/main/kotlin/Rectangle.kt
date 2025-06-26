package org.example

open class Rectangle(val point1: Point, val point2: Point): Shape2D() {
    override fun getArea(): Double {
        return kotlin.math.abs((point2.x - point1.x) * (point2.y - point1.y))
    }

    override fun move(xDelta: Double, yDelta: Double) {
        point1.move(xDelta, yDelta)
        point2.move(xDelta, yDelta)
    }
}