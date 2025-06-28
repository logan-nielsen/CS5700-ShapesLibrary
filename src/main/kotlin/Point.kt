package org.example

class Point(var x: Double, var y: Double): Shape() {
    init {
        require(x.isFinite() && y.isFinite()) { "Point coordinates cannot be infinite or NaN" }
    }

    fun clone(): Point {
        return Point(x, y)
    }

    override fun doMove(xDelta: Double, yDelta: Double) {
        x += xDelta
        y += yDelta
    }
}