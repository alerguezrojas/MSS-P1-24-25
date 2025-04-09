package numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for generating and working with prime numbers.
 */
public class PrimeNumbers {

    /**
     * Returns a list of prime numbers up to a given limit.
     *
     * @param limit The upper limit for generating prime numbers.
     * @return List of prime numbers
     */
    public static List<Integer> getPrimesUpTo(int limit) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    /**
     * Calculates the sum of a list of prime numbers.
     *
     * @param primes List of prime numbers
     * @return Sum of the prime numbers
     */
    public static int sumPrimes(List<Integer> primes) {
        int sum = 0;
        for (int prime : primes) {
            sum += prime;
        }
        return sum;
    }

    /**
     * Checks if a number is prime.
     * @param number Number to check.
     * @return True if the number is prime, false otherwise.
     */
    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
