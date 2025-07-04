import org.example.Point
import org.example.Triangle
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TriangleTest {
    @Test
    fun testGetArea() {
        var triangle = Triangle(Point(0.0, 0.0), Point(1.0, 1.0), Point(-2.0, -1.0))
        assertEquals(0.5, triangle.getArea(), 0.00001)

        triangle = Triangle(Point(-1.0, -1.0), Point(0.0, 0.0), Point(3.5, 2.0))
        assertEquals(0.75, triangle.getArea(), 0.00001)

        triangle = Triangle(Point(1.0, 1.0), Point(-30.0, -150.0), Point(0.0, 0.0))
        assertEquals(60.0, triangle.getArea(), 0.00001)
    }

    @Test
    fun testMove() {
        val triangle = Triangle(Point(0.0, 0.0), Point(3.0, 0.0), Point(0.0, 4.0))
        triangle.move(2.0, 3.0)
        assertEquals(2.0, triangle.point1.x)
        assertEquals(3.0, triangle.point1.y)
        assertEquals(5.0, triangle.point2.x)
        assertEquals(3.0, triangle.point2.y)
        assertEquals(2.0, triangle.point3.x)
        assertEquals(7.0, triangle.point3.y)

        triangle.move(-4.5, -3.5)
        assertEquals(-2.5, triangle.point1.x)
        assertEquals(-0.5, triangle.point1.y)
        assertEquals(0.5, triangle.point2.x)
        assertEquals(-0.5, triangle.point2.y)
        assertEquals(-2.5, triangle.point3.x)
        assertEquals(3.5, triangle.point3.y)

        triangle.move(0.0, 0.0)
        assertEquals(-2.5, triangle.point1.x)
        assertEquals(-0.5, triangle.point1.y)
        assertEquals(0.5, triangle.point2.x)
        assertEquals(-0.5, triangle.point2.y)
        assertEquals(-2.5, triangle.point3.x)
        assertEquals(3.5, triangle.point3.y)
    }

    @Test
    fun testInvalidTriangle() {
        assertFailsWith<IllegalArgumentException> {
            Triangle(Point(0.0, 0.0), Point(0.0, 1.0), Point(0.0, 2.0))
        }
        assertFailsWith<IllegalArgumentException> {
            Triangle(Point(1.0, 1.0), Point(1.0, 2.0), Point(1.0, 4.0))
        }
        assertFailsWith<IllegalArgumentException> {
            Triangle(Point(-1.0, 1.0), Point(-1.0, 2.0), Point(-1.0, 4.0))
        }
        assertFailsWith<IllegalArgumentException> {
            Triangle(Point(1.0, -1.0), Point(1.0, -2.0), Point(1.0, -4.0))
        }
    }

    @Test
    fun testInvalidMove() {
        val triangle = Triangle(Point(0.0, 0.0), Point(1.0, 0.0), Point(0.0, 1.0))
        assertFailsWith<IllegalArgumentException> {
            triangle.move(Double.NaN, 0.0)
        }
        assertFailsWith<IllegalArgumentException> {
            triangle.move(0.0, Double.NaN)
        }
        assertFailsWith<IllegalArgumentException> {
            triangle.move(Double.NEGATIVE_INFINITY, 0.0)
        }
        assertFailsWith<IllegalArgumentException> {
            triangle.move(0.0, Double.NEGATIVE_INFINITY)
        }
        assertFailsWith<IllegalArgumentException> {
            triangle.move(Double.POSITIVE_INFINITY, 0.0)
        }
        assertFailsWith<IllegalArgumentException> {
            triangle.move(0.0, Double.POSITIVE_INFINITY)
        }
    }
}