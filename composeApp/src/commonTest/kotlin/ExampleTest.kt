import kotlin.test.Test
import kotlin.test.assertEquals

class ExampleTest {

    @Test
    fun test(){
        // Given
        val x = 5
        val y = 10
        //When
        val result = x +y
        //Then
        assertEquals(expected = 15, actual = result)
    }
}