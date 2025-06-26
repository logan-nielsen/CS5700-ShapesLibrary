package org.example

class Square(point1: Point, point2: Point) : Rectangle(point1, point2) {
    init {
        val isSquare = kotlin.math.abs(point2.x - point1.x) == kotlin.math.abs(point2.y - point1.y)
        require(isSquare) { "Points must form a square (width must equal height)" }
    }
}