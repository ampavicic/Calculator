package lecture4.ruazosa.fer.hr.calculator

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun subtraction_isCorrect () {
        assertEquals(4, 8 - 4)
    }
    @Test
    fun multiplication_isCorrect () {
        assertEquals(45, 9 * 5)
    }
    @Test
    fun division_isCorret () {
        assertEquals(0.25, 1 / 4)
    }
}
