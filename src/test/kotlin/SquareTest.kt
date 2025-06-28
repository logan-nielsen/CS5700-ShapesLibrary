import org.example.Point
import org.example.Square
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class SquareTest {
    @Test
    fun testGetArea() {
        var square = Square(Point(0.0, 0.0), Point(1.0, 1.0))
        assert(square.getArea() == 1.0)

        square = Square(Point(-2.0, -2.0), Point(0.0, 0.0))
        assert(square.getArea() == 4.0)
    }

    @Test
    fun testMove() {
        val square = Square(Point(0.0, 0.0), Point(1.0, -1.0))
        square.move(2.0, 3.0)
        assertEquals(2.0, square.point1.x)
        assertEquals(3.0, square.point1.y)
        assertEquals(3.0, square.point2.x)
        assertEquals(2.0, square.point2.y)

        square.move(-5.0, -3.0)
        assertEquals(-3.0, square.point1.x)
        assertEquals(0.0, square.point1.y)
        assertEquals(-2.0, square.point2.x)
        assertEquals(-1.0, square.point2.y)

        square.move(0.0, 0.0)
        assertEquals(-3.0, square.point1.x)
        assertEquals(0.0, square.point1.y)
        assertEquals(-2.0, square.point2.x)
        assertEquals(-1.0, square.point2.y)
    }

    @Test
    fun testInvalidSquare() {
        assertFailsWith<IllegalArgumentException> {
            Square(Point(0.0, 0.0), Point(0.0, 0.0))
        }
        assertFailsWith<IllegalArgumentException> {
            Square(Point(0.0, 0.0), Point(1.0, 20.0))
        }
        assertFailsWith<IllegalArgumentException> {
            Square(Point(0.0, -10.0), Point(0.0, 1.0))
        }
        assertFailsWith<IllegalArgumentException> {
            Square(Point(3.0, 0.0), Point(0.0, 0.0))
        }
        assertFailsWith<IllegalArgumentException> {
            Square(Point(2.0, 2.0), Point(-50.0, 0.0))
        }
    }

    @Test
    fun testInvalidMove() {
        val square = Square(Point(0.0, 0.0), Point(1.0, 1.0))
        assertFailsWith<IllegalArgumentException> {
            square.move(Double.NaN, 0.0)
        }
        assertFailsWith<IllegalArgumentException> {
            square.move(0.0, Double.NaN)
        }
        assertFailsWith<IllegalArgumentException> {
            square.move(Double.NEGATIVE_INFINITY, 0.0)
        }
        assertFailsWith<IllegalArgumentException> {
            square.move(0.0, Double.NEGATIVE_INFINITY)
        }
        assertFailsWith<IllegalArgumentException> {
            square.move(Double.POSITIVE_INFINITY, 0.0)
        }
        assertFailsWith<IllegalArgumentException> {
            square.move(0.0, Double.POSITIVE_INFINITY)
        }
    }
}