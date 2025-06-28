import org.example.Point
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class PointTest {
    

    @Test
    fun testClone() {
        val pointsToTest = listOf(
            Point(0.0, 0.0),
            Point(1.0, 1.0),
            Point(-1.0, -1.0),
            Point(1.0, -1.0),
        )

        for (point in pointsToTest) {
            val clone = point.clone()
            assertEquals(point.x, clone.x)
            assertEquals(point.y, clone.y)
        }
    }

    @Test
    fun testMove() {
        val point = Point(1.0, 1.0)

        point.move(2.0, 3.0)
        assertEquals(3.0, point.x)
        assertEquals(4.0, point.y)

        point.move(-1.0, -2.0)
        assertEquals(2.0, point.x)
        assertEquals(2.0, point.y)

        point.move(0.0, 0.0)
        assertEquals(2.0, point.x)
        assertEquals(2.0, point.y)

        point.move(-2.0, 0.0)
        assertEquals(0.0, point.x)
        assertEquals(2.0, point.y)

        point.move(1.0, -2.0)
        assertEquals(1.0, point.x)
        assertEquals(0.0, point.y)
    }

    @Test
    fun testInvalidPoint() {
        val invalidValues = listOf(Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)

        for (invalidValue in invalidValues) {
            assertFailsWith<IllegalArgumentException> {
                Point(invalidValue, 0.0)
            }
            assertFailsWith<IllegalArgumentException> {
                Point(0.0, invalidValue)
            }
        }

    }
}