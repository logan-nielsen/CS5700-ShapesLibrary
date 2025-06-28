package org.example

class Triangle(val point1: Point, val point2: Point, val point3: Point) : Shape2D() {
    init {
        val line1 = Line(point1, point2)
        val line2 = Line(point2, point3)
        val line3 = Line(point3, point1)
        require(
            !(line1.getLength() + line2.getLength() <= line3.getLength() ||
                    line2.getLength() + line3.getLength() <= line1.getLength() ||
                    line3.getLength() + line1.getLength() <= line2.getLength())
        ) { "Points must form a valid triangle" }
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