package app;

import numbers.FibonacciSeries;
import numbers.PrimeNumbers;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prime numbers
        System.out.println("PRIME NUMBERS");
        System.out.print("Enter a limit to generate prime numbers: ");
        int limit = scanner.nextInt();
        List<Integer> primes = PrimeNumbers.getPrimesUpTo(limit);
        System.out.println("Prime numbers up to " + limit + ": " + primes);
        System.out.println("Sum of prime numbers: " + PrimeNumbers.sumPrimes(primes));

        // Fibonacci series
        System.out.println("\nFIBONACCI SERIES");
        System.out.println("Enter the number of Fibonacci numbers to generate: ");
        long n = scanner.nextInt();
        List<Long> fibonacciNumbers = FibonacciSeries.generateFibonacci(n);
        System.out.println("Fibonacci series: " + fibonacciNumbers);

    }
}