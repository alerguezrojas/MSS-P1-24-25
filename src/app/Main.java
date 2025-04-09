package app;

import numbers.PrimeNumbers;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prime numbers
        System.out.print("Enter a limit to generate prime numbers: ");
        int limit = scanner.nextInt();
        List<Integer> primes = PrimeNumbers.getPrimesUpTo(limit);
        System.out.println("Prime numbers up to " + limit + ": " + primes);
        System.out.println("Sum of prime numbers: " + PrimeNumbers.sumPrimes(primes));

    }
}