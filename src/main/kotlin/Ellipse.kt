package org.example

open class Ellipse(private val center: Point, private val radius1: Double, private val radius2: Double) : Shape2D() {
    init {
        val area = getArea()
        require(area != 0.0) { "Area cannot be zero" }
    }

    override fun getArea(): Double {
        return Math.PI * radius1 * radius2
    }

    override fun move(xDelta: Double, yDelta: Double) {
        center.move(xDelta, yDelta)
    }
}