package numbers;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class FibonacciSeriesTest {

    @Test
    public void testGenerateFibonacci() {
        List<Long> expected = List.of(0L, 1L, 1L, 2L, 3L, 5L);
        assertEquals(expected, FibonacciSeries.generateFibonacci(6));
    }

    @Test
    public void testGenerateFibonacciInInterval() {
        assertEquals(List.of(5L, 8L, 13L), FibonacciSeries.generateFibonacciInInterval(4, 20));
    }

    @Test
    public void testIsFibonacci() {
        assertTrue(FibonacciSeries.isFibonacci(21));
        assertFalse(FibonacciSeries.isFibonacci(22));
    }
}
