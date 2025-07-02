package org.example

class Triangle(val point1: Point, val point2: Point, val point3: Point) : Shape2D() {
    init {
        require(this.getArea() > 0) { "Points must form a valid triangle" }
    }

    override fun getArea(): Double {
        val a = Line(point1, point2).getLength()
        val b = Line(point2, point3).getLength()
        val c = Line(point3, point1).getLength()
        val s = (a + b + c) / 2
        return kotlin.math.sqrt(s * (s - a) * (s - b) * (s - c))
    }

    override fun doMove(xDelta: Double, yDelta: Double) {
        point1.move(xDelta, yDelta)
        point2.move(xDelta, yDelta)
        point3.move(xDelta, yDelta)
    }
}