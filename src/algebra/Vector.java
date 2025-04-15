package algebra;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Class that represents an n-dimensional vector of real numbers.
 */
public class Vector {

    private final double[] components; // final means that the reference to the array cannot be changed

    /**
     * Constructs a vector of the given dimension with all values initialized to zero.
     *
     * @param dimension The dimension of the vector.
     */
    public Vector(int dimension) {
        this.components = new double[dimension]; // this is used to refer to the current object
    }

    /**
     * Constructs a vector with the given array of components.
     *
     * @param components The array of components.
     */
    public Vector(double[] components) {
        this.components = components.clone(); // clone creates a new array with the same values
    }

    /**
     * Returns the dimension of the vector.
     *
     * @return The dimension of the vector.
     */
    public int getDimension() {
        return components.length;
    }

    /**
     * Returns the dot product between this vector and another vector.
     *
     * @param other The other vector.
     * @return The dot product result.
     * @throws IllegalArgumentException if the dimensions of the vectors do not match.
     */
    public double dotProduct(Vector other) {
        if (this.getDimension() != other.getDimension()) {
            throw new IllegalArgumentException("Vectors must have the same dimension for dot product.");
        }
        double result = 0;
        for (int i = 0; i < this.getDimension(); i++) {
            result += this.components[i] * other.components[i];
        }
        return result;
    }

    /**
     * Prints the components of the vector to the console.
     */
    public void print() {
        System.out.println(Arrays.toString(this.components));
    }

    /**
     * Reads a vector of a given dimension from the console.
     *
     * @param scanner The scanner to read from the console.
     * @param dimension The dimension of the vector.
     * @return A new vector with user-provided components.
     */
    public static Vector readFromInput(Scanner scanner, int dimension) {
        double[] components = new double[dimension];
        for (int i = 0; i < dimension; i++) {
            components[i] = scanner.nextDouble();
        }
        return new Vector(components);
    }

    /**
     * Writes the components of the vector to a plain text file, separated by commas.
     *
     * @param fileName Name of a file to write the vector to.
     * @throws IOException if an error occurs while writing to the file.
     */
    public void write(String fileName) throws IOException {
        try(FileWriter writer = new FileWriter(fileName)) {
            for (int i = 0; i < components.length; i++) {
                writer.write(Double.toString(components[i]));
                if (i < components.length - 1) {
                    writer.write(", ");
                }
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            throw e;
        }
    }

}
