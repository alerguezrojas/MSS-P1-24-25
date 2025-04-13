package numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for generating and analyzing Fibonacci series.
 */
public class FibonacciSeries {

    /**
     * Generates the first n Fibonacci numbers.
     *
     * @param n The number of Fibonacci numbers to generate.
     * @return List of Fibonacci numbers.
     */
    public static List<Long> generateFibonacci(long n) {
        return generateUpTo(n, Long.MAX_VALUE, true);
    }

    /**
     * Generates the elements of the Fibonacci series included in a given interval [n1, n2].
     *
     * @param n1 The lower bound of the interval.
     * @param n2 The upper bound of the interval.
     * @return List of Fibonacci numbers within the interval.
     */
    public static List<Long> generateFibonacciInInterval(long n1, long n2) {
        List<Long> all = generateUpTo(Long.MAX_VALUE, n2, false);
        List<Long> filtered = new ArrayList<>();
        for (Long num : all) {
            if (num >= n1) {
                filtered.add(num);
            }
        }
        return filtered;
    }

    /**
     * Determines if a number is part of the Fibonacci series.
     *
     * @param number The number to check.
     * @return True if the number is part of the Fibonacci series, false otherwise.
     */
    public static boolean isFibonacci(long number) {
        List<Long> all = generateUpTo(Long.MAX_VALUE, number, false);
        return all.contains(number);
    }

    /**
     * Central method to generate Fibonacci numbers.
     *
     * @param countLimit Max number of elements (if active).
     * @param valueLimit Max value to reach (if active).
     * @param useCount   Whether to use count limit or value limit.
     * @return List of Fibonacci numbers.
     */
    private static List<Long> generateUpTo(long countLimit, long valueLimit, boolean useCount) {
        List<Long> fibonacciNumbers = new ArrayList<>();
        long a = 0, b = 1;

        while ((useCount && fibonacciNumbers.size() < countLimit) ||
                (!useCount && a <= valueLimit)) {
            fibonacciNumbers.add(a);
            long c = a + b;
            a = b;
            b = c;
        }

        return fibonacciNumbers;
    }
}
