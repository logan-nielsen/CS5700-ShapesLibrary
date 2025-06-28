import org.example.Circle
import org.example.Point
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CircleTest {
    @Test
    fun testGetArea() {
        var circle = Circle(Point(0.0, 0.0), 1.0)
        assertEquals(Math.PI, circle.getArea())

        circle = Circle(Point(-5.0, -1.0), 2.0)
        assertEquals(Math.PI * 4, circle.getArea())

        circle = Circle(Point(2.0, 4.0), 3.0)
        assertEquals(Math.PI * 9, circle.getArea())
    }

    @Test
    fun testMove() {
        val circle = Circle(Point(0.0, 0.0), 1.0)
        circle.move(2.0, 3.0)
        assertEquals(circle.center.x, 2.0)
        assertEquals(circle.center.y, 3.0)

        circle.move(-5.0, -2.5)
        assertEquals(circle.center.x, -3.0)
        assertEquals(circle.center.y, 0.5)

        circle.move(0.0, 0.0)
        assertEquals(circle.center.x, -3.0)
        assertEquals(circle.center.y, 0.5)
    }

    @Test
    fun testInvalidCircle() {
        assertFailsWith<IllegalArgumentException> {
            Circle(Point(0.0, 0.0), 0.0)
            Circle(Point(-20.0, 3.0), -1.0)
        }
    }
}