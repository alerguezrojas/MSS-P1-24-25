package numbers;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class PrimeNumbersTest {

    @Test
    public void testGetPrimesUpTo10() {
        List<Integer> primes = PrimeNumbers.getPrimesUpTo(10);
        assertEquals(List.of(2, 3, 5, 7), primes);
    }

    @Test
    public void testSumPrimes() {
        assertEquals(17, PrimeNumbers.sumPrimes(List.of(2, 3, 5, 7)));
    }

    @Test
    public void testNoPrimesBelow2() {
        assertTrue(PrimeNumbers.getPrimesUpTo(1).isEmpty());
    }
}
