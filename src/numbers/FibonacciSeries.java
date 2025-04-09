package numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for generating and analyzing Fibonacci series.
 */
public class FibonacciSeries {

    /**
     * Generates the first n Fibonacci numbers.
     */
    public static List<Long> generateFibonacci(long n) {
        List<Long> fibonacciNumbers = new ArrayList<>();
        long a = 0, b = 1;
        for (long i = 0; i < n; i++) {
            fibonacciNumbers.add(a);
            long c = a + b;
            a = b;
            b = c;
        }
        return fibonacciNumbers;
    }



}
