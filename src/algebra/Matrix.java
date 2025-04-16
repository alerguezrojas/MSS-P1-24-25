package algebra;


/**
 * Class that represents a 2D matrix using Vector rows.
 */
public class Matrix {

    private final Vector[] rows;

    /**
     * Default constructor: creates a 1x1 matrix with a zero.
     */
    public Matrix() {
        this(1, 1);
    }

    /**
     * Creates a matrix with m rows and n columns initialized to zeros
     *
     * @param m Number of rows
     * @param n Number of columns
     */
    public Matrix(int m, int n) {
        rows = new Vector[m];
        for (int i = 0; i < m; i++) {
            rows[i] = new Vector(n);
        }
    }

    /**
     * Creates a matrix with the given data array.
     *
     * @param data 2D array of doubles
     */
    public Matrix(double[][] data) {
        this(data.length, data[0].length); // Delegate to the constructor with m and n
        for(int i = 0; i < data.length; i++) {
            rows[i] = new Vector(data[i]);
        }
    }

    /**
     * Returns the number of rows in the matrix.
     *
     * @return Number of rows
     */
    public int getNumRow() {
        return rows.length;
    }

    /**
     * Returns the number of columns in the matrix.
     *
     * @return Number of columns
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


}
