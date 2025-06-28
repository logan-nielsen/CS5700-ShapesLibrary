import org.example.Ellipse
import org.example.Point
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class EllipseTest {
    @Test
    fun testGetArea() {
        var ellipse = Ellipse(Point(0.0, 0.0), 1.0, 1.0)
        assertEquals(Math.PI, ellipse.getArea())

        ellipse = Ellipse(Point(-5.0, -1.0), 2.0, 1.0)
        assertEquals(Math.PI * 2, ellipse.getArea())

        ellipse = Ellipse(Point(2.0, 4.0), 4.0, 3.5)
        assertEquals( Math.PI * 14,ellipse.getArea())
    }

    @Test
    fun testMove() {
        val ellipse = Ellipse(Point(0.0, 0.0), 1.0, 1.0)
        ellipse.move(2.0, 3.0)
        assertEquals(ellipse.center.x, 2.0)
        assertEquals(ellipse.center.y, 3.0)

        ellipse.move(-5.0, -2.5)
        assertEquals(ellipse.center.x, -3.0)
        assertEquals(ellipse.center.y, 0.5)

        ellipse.move(0.0, 0.0)
        assertEquals(ellipse.center.x, -3.0)
        assertEquals(ellipse.center.y, 0.5)
    }

    @Test
    fun testInvalidEllipse() {
        assertFailsWith<IllegalArgumentException> {
            Ellipse(Point(0.0, 0.0), 0.0, 1.0)
            Ellipse(Point(0.0, 0.0), 1.0, 0.0)
            Ellipse(Point(0.0, 0.0), -1.0, 1.0)
            Ellipse(Point(0.0, 0.0), 1.0, -1.0)
        }
    }
}