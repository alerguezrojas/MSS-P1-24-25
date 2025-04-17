package algebra;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents a 2D matrix using Vector rows.
 */
public class Matrix {

    private final Vector[] rows;

    /**
     * Creates a 1x1 matrix initialized to 0.
     */
    public Matrix() {
        this(1, 1);
    }

    /**
     * Creates an m x n matrix initialized to zeros.
     *
     * @param m Number of rows.
     * @param n Number of columns.
     */
    public Matrix(int m, int n) {
        rows = new Vector[m];
        for (int i = 0; i < m; i++) {
            rows[i] = new Vector(n);
        }
    }

    /**
     * Creates a matrix from a 2D array of data.
     *
     * @param data 2D array of doubles.
     */
    public Matrix(double[][] data) {
        this(data.length, data[0].length);
        for (int i = 0; i < data.length; i++) {
            rows[i] = new Vector(data[i]);
        }
    }

    /**
     * Returns the number of rows in the matrix.
     */
    public int getNumRow() {
        return rows.length;
    }

    /**
     * Returns the number of columns in the matrix.
     */
    public int getNumCol() {
        return rows[0].getDimension();
    }

    /**
     * Prints the matrix to the console.
     */
    public void print() {
        for (Vector row : rows) {
            row.print();
        }
    }

    /**
     * Multiplies this matrix with another matrix.
     *
     * @param other The matrix to multiply by.
     * @return A new matrix containing the result.
     * @throws IllegalArgumentException If dimensions are incompatible.
     */
    public Matrix multiply(Matrix other) {
        if (this.getNumCol() != other.getNumRow()) {
            throw new IllegalArgumentException("Matrix dimensions are incompatible.");
        }

        int m = this.getNumRow();
        int p = other.getNumCol();
        Matrix result = new Matrix(m, p);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                double value = this.rows[i].dotProduct(other.getColumn(j));
                result.rows[i].setComponent(j, value);
            }
        }

        return result;
    }

    /**
     * Returns a column of the matrix as a Vector.
     *
     * @param colIndex Index of the column.
     * @return A Vector containing the column values.
     */
    public Vector getColumn(int colIndex) {
        double[] column = new double[getNumRow()];
        for (int i = 0; i < getNumRow(); i++) {
            column[i] = this.rows[i].getComponent(colIndex);
        }
        return new Vector(column);
    }

    /**
     * Returns a row of the matrix as a Vector.
     *
     * @param rowIndex Index of the row.
     * @return A Vector containing the row values.
     */
    public Vector getRow(int rowIndex) {
        return rows[rowIndex];
    }

    /**
     * Reads a matrix from user input.
     *
     * @param scanner Scanner instance.
     * @param rows Number of rows.
     * @param cols Number of columns.
     * @return A new Matrix object with user-entered data.
     */
    public static Matrix readFromInput(Scanner scanner, int rows, int cols) {
        Matrix matrix = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            System.out.println("Enter values for row " + (i + 1) + ":");
            matrix.rows[i] = Vector.readFromInput(scanner, cols);
        }
        return matrix;
    }

    /**
     * Writes the matrix to a plain text file without dimensions.
     *
     * @param fileName Name of the file to write to.
     * @throws IOException If writing fails.
     */
    public void write(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Vector row : rows) {
                writer.write(row.toCsvLine());
                writer.newLine();
            }
        }
    }

    /**
     * Reads a matrix from a plain text file where each line is a row of comma-separated values.
     *
     * @param fileName The file to read.
     * @return A new Matrix object.
     * @throws IOException If reading fails.
     */
    public static Matrix read(String fileName) throws IOException {
        List<double[]> rowList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                double[] row = new double[tokens.length];
                for (int i = 0; i < tokens.length; i++) {
                    row[i] = Double.parseDouble(tokens[i]);
                }
                rowList.add(row);
            }
        }

        double[][] data = new double[rowList.size()][];
        for (int i = 0; i < rowList.size(); i++) {
            data[i] = rowList.get(i);
        }

        return new Matrix(data);
    }
}
