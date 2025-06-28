import org.example.Line
import org.example.Point
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class LineTest {
    @Test
    fun testGetSlope() {
        var line = Line(Point(0.0, 0.0), Point(1.0, 1.0))
        assertEquals(1.0, line.getSlope())

        line = Line(Point(0.0, 0.0), Point(1.0, 0.0))
        assertEquals(0.0, line.getSlope())

        line = Line(Point(-1.0, -1.0), Point(0.0, 0.0))
        assertEquals(1.0, line.getSlope())

        line = Line(Point(1.0, -2.0), Point(0.0, 0.0))
        assertEquals(-2.0, line.getSlope())

        line = Line(Point(0.0, 0.0), Point(-2.0, 1.0))
        assertEquals(-.5, line.getSlope())
    }

    @Test
    fun testInfiniteSlope() {
        var line = Line(Point(0.0, 0.0), Point(0.0, 1.0))
        assertEquals(true, line.getSlope().isInfinite())

        line = Line(Point(0.0, -1.0), Point(0.0, 0.0))
        assertEquals(true, line.getSlope().isInfinite())
    }

    @Test
    fun testGetLength() {
        var line = Line(Point(0.0, 0.0), Point(1.0, 1.0))
        assertEquals(1.414214, line.getLength(), 0.00001)

        line = Line(Point(1.0, 5.0), Point(-1.0, -2.0))
        assertEquals(7.28011, line.getLength(), 0.00001)

        line = Line(Point(-50.0, 20.0), Point(70.0, -2.0))
        assertEquals(122.0, line.getLength(), 0.00001)
    }

    @Test
    fun testMove() {
        val line = Line(Point(0.0, 0.0), Point(1.0, -1.0))
        line.move(2.0, 3.0)
        assertEquals(2.0, line.point1.x)
        assertEquals(3.0, line.point1.y)
        assertEquals(3.0, line.point2.x)
        assertEquals(2.0, line.point2.y)

        line.move(-5.0, -3.0)
        assertEquals(-3.0, line.point1.x)
        assertEquals(0.0, line.point1.y)
        assertEquals(-2.0, line.point2.x)
        assertEquals(-1.0, line.point2.y)

        line.move(0.0, 0.0)
        assertEquals(-3.0, line.point1.x)
        assertEquals(0.0, line.point1.y)
        assertEquals(-2.0, line.point2.x)
        assertEquals(-1.0, line.point2.y)
    }

    @Test
    fun testInvalidLine() {
        assertFailsWith<IllegalArgumentException> {
            Line(Point(0.0, 0.0), Point(0.0, 0.0))
        }
    }
}