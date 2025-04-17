package algebra;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class that represents a numeric vector.
 */
public class Vector {

    private final double[] components;

    /**
     * Constructs a vector with the given dimension, initialized to zeros.
     *
     * @param dimension Number of components.
     */
    public Vector(int dimension) {
        this.components = new double[dimension];
    }

    /**
     * Constructs a vector with the given array of components.
     *
     * @param components Array of component values.
     */
    public Vector(double[] components) {
        this.components = components.clone();
    }

    /**
     * Returns the dimension of the vector.
     *
     * @return The number of components.
     */
    public int getDimension() {
        return components.length;
    }

    /**
     * Returns the i-th component of the vector.
     *
     * @param index Index of the component.
     * @return Value at the index.
     */
    public double getComponent(int index) {
        return components[index];
    }

    /**
     * Sets the value of the i-th component.
     *
     * @param index Index to set.
     * @param value Value to assign.
     */
    public void setComponent(int index, double value) {
        components[index] = value;
    }

    /**
     * Returns the dot product of this vector and another.
     *
     * @param other The other vector.
     * @return The dot product result.
     * @throws IllegalArgumentException If dimensions don't match.
     */
    public double dotProduct(Vector other) {
        if (this.getDimension() != other.getDimension()) {
            throw new IllegalArgumentException("Vectors must have the same dimension.");
        }

        double sum = 0;
        for (int i = 0; i < components.length; i++) {
            sum += this.components[i] * other.components[i];
        }

        return sum;
    }

    /**
     * Prints the vector components to the console.
     */
    public void print() {
        System.out.println(Arrays.toString(components));
    }

    /**
     * Converts the vector to a comma-separated string (e.g., "1.0,2.0,3.0").
     *
     * @return CSV-style string of the vector.
     */
    public String toCsvLine() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < components.length; i++) {
            sb.append(components[i]);
            if (i < components.length - 1) sb.append(",");
        }
        return sb.toString();
    }

    /**
     * Writes the vector components to a plain text file,
     * with components separated by commas.
     *
     * @param fileName The name of the .txt file.
     * @throws IOException If an I/O error occurs.
     */
    public void write(String fileName) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(this.toCsvLine());
        }
    }

    /**
     * Reads a vector of given dimension from user input.
     *
     * @param scanner Scanner instance.
     * @param dimension Number of components.
     * @return A new vector with user input values.
     */
    public static Vector readFromInput(Scanner scanner, int dimension) {
        double[] data = new double[dimension];
        for (int i = 0; i < dimension; i++) {
            System.out.print("Component " + (i + 1) + ": ");
            data[i] = scanner.nextDouble();
        }
        return new Vector(data);
    }
}
