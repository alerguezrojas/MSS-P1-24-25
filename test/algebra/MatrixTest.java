package algebra;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

public class MatrixTest {

    @Test
    public void testDefaultConstructorCreates1x1() {
        Matrix m = new Matrix();
        assertEquals(1, m.getNumRow());
        assertEquals(1, m.getNumCol());
        assertEquals(0.0, m.getColumn(0).getComponent(0), 0.0001);
    }

    @Test
    public void testMatrixDimensions() {
        Matrix m = new Matrix(2, 3);
        assertEquals(2, m.getNumRow());
        assertEquals(3, m.getNumCol());
    }

    @Test
    public void testMatrixMultiplication() {
        Matrix A = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Matrix B = new Matrix(new double[][]{{5, 6}, {7, 8}});
        Matrix result = A.multiply(B);
        Matrix expected = new Matrix(new double[][]{{19, 22}, {43, 50}});
        assertEquals(expected.getNumRow(), result.getNumRow());
        assertEquals(expected.getNumCol(), result.getNumCol());

        for (int i = 0; i < expected.getNumRow(); i++) {
            for (int j = 0; j < expected.getNumCol(); j++) {
                assertEquals(
                        expected.getColumn(j).getComponent(i),
                        result.getColumn(j).getComponent(i),
                        0.0001
                );
            }
        }
    }

    @Test
    public void testIncompatibleMultiplicationThrows() {
        Matrix A = new Matrix(2, 3);
        Matrix B = new Matrix(2, 2);
        assertThrows(IllegalArgumentException.class, () -> A.multiply(B));
    }

    @Test
    public void testReadWriteMatrix() throws IOException {
        Matrix original = new Matrix(new double[][]{
                {1.1, 2.2},
                {3.3, 4.4}
        });

        String filename = "temp_matrix.txt";
        original.write(filename);
        Matrix loaded = Matrix.read(filename);

        assertEquals(original.getNumRow(), loaded.getNumRow());
        assertEquals(original.getNumCol(), loaded.getNumCol());

        for (int i = 0; i < original.getNumRow(); i++) {
            for (int j = 0; j < original.getNumCol(); j++) {
                assertEquals(
                        original.getColumn(j).getComponent(i),
                        loaded.getColumn(j).getComponent(i),
                        0.0001
                );
            }
        }

        File file = new File(filename);
        assertTrue(file.delete(), "Temporary matrix file was not deleted.");
    }
}
