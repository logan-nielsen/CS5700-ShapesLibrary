package org.example

open class Rectangle(val point1: Point, val point2: Point): Shape2D() {
    init {
        val width = kotlin.math.abs(point2.x - point1.x)
        val height = kotlin.math.abs(point2.y - point1.y)
        require(width > 0 && height > 0) { "Width and height cannot be 0" }
    }

    override fun getArea(): Double {
        return kotlin.math.abs((point2.x - point1.x) * (point2.y - point1.y))
    }

    override fun move(xDelta: Double, yDelta: Double) {
        point1.move(xDelta, yDelta)
        point2.move(xDelta, yDelta)
    }
}