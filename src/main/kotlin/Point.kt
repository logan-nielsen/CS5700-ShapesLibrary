package org.example

class Point(var x: Double, var y: Double): Shape() {
    fun clone(): Point {
        return Point(x, y)
    }

    override fun move(xDelta: Double, yDelta: Double) {
        x += xDelta
        y += yDelta
    }
}