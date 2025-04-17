package app;

import numbers.PrimeNumbers;
import numbers.FibonacciSeries;
import algebra.Vector;
import algebra.Matrix;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Main class for interacting with the application.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== MENU ===");
        System.out.println("1. Prime Numbers");
        System.out.println("2. Fibonacci Series");
        System.out.println("3. Vector Operations");
        System.out.println("4. Matrix Operations");
        System.out.print("Select an option (1-4): ");

        int option = scanner.nextInt();
        System.out.println();

        switch (option) {
            case 1 -> handlePrimeNumbers(scanner);
            case 2 -> handleFibonacciSeries(scanner);
            case 3 -> handleVectorOperations(scanner);
            case 4 -> handleMatrixOperations(scanner);
            default -> System.out.println("Invalid option. Exiting.");
        }

        scanner.close();
    }

    // PRIME NUMBERS
    private static void handlePrimeNumbers(Scanner scanner) {
        System.out.print("Enter upper limit to generate prime numbers: ");
        int limit = scanner.nextInt();

        List<Integer> primes = PrimeNumbers.getPrimesUpTo(limit);
        System.out.println("Prime numbers up to " + limit + ": " + primes);
        System.out.println("Sum of primes: " + PrimeNumbers.sumPrimes(primes));
    }

    // FIBONACCI
    private static void handleFibonacciSeries(Scanner scanner) {
        System.out.print("Enter number of Fibonacci elements to generate: ");
        long n = scanner.nextLong();
        System.out.println("First " + n + " Fibonacci numbers:");
        System.out.println(FibonacciSeries.generateFibonacci(n));

        System.out.print("Enter interval [min max] to list Fibonacci numbers: ");
        long min = scanner.nextLong();
        long max = scanner.nextLong();
        System.out.println("Fibonacci numbers in interval [" + min + ", " + max + "]:");
        System.out.println(FibonacciSeries.generateFibonacciInInterval(min, max));

        System.out.print("Enter a number to check if it's in the Fibonacci sequence: ");
        long num = scanner.nextLong();
        System.out.println("Is Fibonacci? " + FibonacciSeries.isFibonacci(num));
    }

    // VECTOR
    private static void handleVectorOperations(Scanner scanner) {
        System.out.print("Enter the dimension of the vectors: ");
        int dim = scanner.nextInt();

        System.out.println("Enter components for Vector 1:");
        Vector v1 = Vector.readFromInput(scanner, dim);
        System.out.println("Enter components for Vector 2:");
        Vector v2 = Vector.readFromInput(scanner, dim);

        System.out.println("\nVector 1:");
        v1.print();
        System.out.println("Vector 2:");
        v2.print();

        System.out.println("Dot product: " + v1.dotProduct(v2));

        System.out.print("Enter filename to save Vector 1 (e.g., vector.txt): ");
        String fileName = scanner.next();
        try {
            v1.write(fileName);
            System.out.println("Vector 1 written to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // MATRIX
    private static void handleMatrixOperations(Scanner scanner) {
        // MANUAL INPUT
        System.out.println("=== Manual Matrix Input ===");
        System.out.print("Enter number of rows and columns for Matrix A: ");
        int rowsA = scanner.nextInt();
        int colsA = scanner.nextInt();
        Matrix A = Matrix.readFromInput(scanner, rowsA, colsA);

        System.out.print("Enter number of rows and columns for Matrix B: ");
        int rowsB = scanner.nextInt();
        int colsB = scanner.nextInt();
        Matrix B = Matrix.readFromInput(scanner, rowsB, colsB);

        System.out.println("\nMatrix A:");
        A.print();
        System.out.println("Matrix B:");
        B.print();

        if (colsA == rowsB) {
            Matrix product = A.multiply(B);
            System.out.println("Product A × B:");
            product.print();
        } else {
            System.out.println("Matrices are incompatible for multiplication.");
        }

        // FILE INPUT
        System.out.println("\n=== File Matrix Input ===");
        System.out.print("Enter filename for Matrix A (e.g., matrixA.txt): ");
        String fileA = scanner.next();
        System.out.print("Enter filename for Matrix B (e.g., matrixB.txt): ");
        String fileB = scanner.next();

        try {
            Matrix matA = Matrix.read(fileA);
            Matrix matB = Matrix.read(fileB);

            System.out.println("\nMatrix A from file:");
            matA.print();
            System.out.println("Matrix B from file:");
            matB.print();

            if (matA.getNumCol() == matB.getNumRow()) {
                Matrix product = matA.multiply(matB);
                System.out.println("Product A × B from file:");
                product.print();

                System.out.print("Enter filename to save the result (e.g., result.txt): ");
                String output = scanner.next();
                product.write(output);
                System.out.println("Result written to " + output);
            } else {
                System.out.println("Matrices from file are incompatible for multiplication.");
            }

        } catch (IOException e) {
            System.out.println("Error reading or writing matrices: " + e.getMessage());
        }
    }

}
