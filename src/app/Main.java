package app;

import algebra.Vector;
import numbers.FibonacciSeries;
import numbers.PrimeNumbers;

import java.io.IOException;
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
        System.out.print("Enter the number of Fibonacci numbers to generate: ");
        long n = scanner.nextLong();
        List<Long> fibonacciNumbers = FibonacciSeries.generateFibonacci(n);
        System.out.println("Fibonacci numbers: " + fibonacciNumbers);
        System.out.println("Generating Fibonacci numbers in the interval [n1, n2]");
        System.out.print("Enter the lower bound (n1): ");
        long n1 = scanner.nextLong();
        System.out.print("Enter the upper bound (n2): ");
        long n2 = scanner.nextLong();
        List<Long> fibonacciInInterval = FibonacciSeries.generateFibonacciInInterval(n1, n2);
        System.out.println("Fibonacci numbers in the interval [" + n1 + ", " + n2 + "]: " + fibonacciInInterval);
        System.out.println("Checking if a number is part of the Fibonacci series");
        System.out.print("Enter a number to check: ");
        long number = scanner.nextLong();
        boolean isFibonacci = FibonacciSeries.isFibonacci(number);
        if (isFibonacci) {
            System.out.println(number + " is part of the Fibonacci series.");
        } else {
            System.out.println(number + " is not part of the Fibonacci series.");
        }

        // Vector operations
        System.out.println("\nVECTOR OPERATIONS");
        System.out.print("Enter the dimension of the vectors: ");;
        int dimension = scanner.nextInt();
        System.out.println("Enter the components of the first vector (separated by spaces):");
        Vector v1 = Vector.readFromInput(scanner, dimension);
        System.out.println("Enter the components of the second vector (separated by spaces):");
        Vector v2 = Vector.readFromInput(scanner, dimension);
        System.out.println("\nVector 1:");
        v1.print();
        v1.getDimension();
        System.out.println("Vector 2:");
        v2.print();
        v2.getDimension();
        System.out.println("Dot product of the vectors: " + v1.dotProduct(v2));
        System.out.print("Enter a file name to write the first vector: ");
        String fileName = scanner.next();
        try {
            v1.write(fileName);
            System.out.println("Vector written to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

    }
}