package org.example

class Point(var x: Double, var y: Double): Shape() {
    init {
        require(x.isFinite() && y.isFinite()) { "Point coordinates cannot be infinite or NaN" }
    }

    fun clone(): Point {
        return Point(x, y)
    }

    override fun move(xDelta: Double, yDelta: Double) {
        require(xDelta.isFinite() && yDelta.isFinite()) { "Move deltas cannot be infinite or NaN" }

        x += xDelta
        y += yDelta
    }
}