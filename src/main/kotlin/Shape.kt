package org.example

abstract class Shape {
    fun move(xDelta: Double, yDelta: Double) {
        require(xDelta.isFinite() && yDelta.isFinite()) { "Move deltas cannot be infinite or NaN" }
        doMove(xDelta, yDelta)
    }

    abstract fun doMove(xDelta: Double, yDelta: Double)
}