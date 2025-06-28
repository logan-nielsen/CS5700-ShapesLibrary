import org.example.Point
import org.example.Rectangle
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class RectangleTest {
    @Test
    fun testGetArea() {
        var rectangle = Rectangle(Point(0.0, 0.0), Point(1.0, 1.0))
        assert(rectangle.getArea() == 1.0)

        rectangle = Rectangle(Point(-2.0, -1.0), Point(0.0, 0.0))
        assert(rectangle.getArea() == 2.0)
    }

    @Test
    fun testMove() {
        val rectangle = Rectangle(Point(0.0, 0.0), Point(1.0, -1.0))
        rectangle.move(2.0, 3.0)
        assertEquals(2.0, rectangle.point1.x)
        assertEquals(3.0, rectangle.point1.y)
        assertEquals(3.0, rectangle.point2.x)
        assertEquals(2.0, rectangle.point2.y)

        rectangle.move(-5.0, -3.0)
        assertEquals(-3.0, rectangle.point1.x)
        assertEquals(0.0, rectangle.point1.y)
        assertEquals(-2.0, rectangle.point2.x)
        assertEquals(-1.0, rectangle.point2.y)

        rectangle.move(0.0, 0.0)
        assertEquals(-3.0, rectangle.point1.x)
        assertEquals(0.0, rectangle.point1.y)
        assertEquals(-2.0, rectangle.point2.x)
        assertEquals(-1.0, rectangle.point2.y)
    }

    @Test
    fun testInvalidRectangle() {
        assertFailsWith<IllegalArgumentException> {
            Rectangle(Point(0.0, 0.0), Point(0.0, 0.0))
        }
        assertFailsWith<IllegalArgumentException> {
            Rectangle(Point(0.0, 0.0), Point(0.0, 20.0))
        }
        assertFailsWith<IllegalArgumentException> {
            Rectangle(Point(0.0, -10.0), Point(0.0, 0.0))
        }
        assertFailsWith<IllegalArgumentException> {
            Rectangle(Point(20.0, 0.0), Point(0.0, 0.0))
        }
        assertFailsWith<IllegalArgumentException> {
            Rectangle(Point(0.0, 0.0), Point(-50.0, 0.0))
        }
    }

    @Test
    fun testInvalidMove() {
        val rectangle = Rectangle(Point(0.0, 0.0), Point(1.0, 1.0))
        assertFailsWith<IllegalArgumentException> {
            rectangle.move(Double.NaN, 0.0)
        }
        assertFailsWith<IllegalArgumentException> {
            rectangle.move(0.0, Double.NaN)
        }
        assertFailsWith<IllegalArgumentException> {
            rectangle.move(Double.NEGATIVE_INFINITY, 0.0)
        }
        assertFailsWith<IllegalArgumentException> {
            rectangle.move(0.0, Double.NEGATIVE_INFINITY)
        }
        assertFailsWith<IllegalArgumentException> {
            rectangle.move(Double.POSITIVE_INFINITY, 0.0)
        }
        assertFailsWith<IllegalArgumentException> {
            rectangle.move(0.0, Double.POSITIVE_INFINITY)
        }
    }
}