package algebra;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VectorTest {

    @Test
    public void testDimension() {
        Vector v = new Vector(new double[]{1.0, 2.0});
        assertEquals(2, v.getDimension());
    }

    @Test
    public void testDotProduct() {
        Vector v1 = new Vector(new double[]{1.0, 2.0});
        Vector v2 = new Vector(new double[]{3.0, 4.0});
        assertEquals(11.0, v1.dotProduct(v2));
    }

    @Test
    public void testDotProductInvalidDimension() {
        Vector v1 = new Vector(new double[]{1.0});
        Vector v2 = new Vector(new double[]{1.0, 2.0});
        assertThrows(IllegalArgumentException.class, () -> v1.dotProduct(v2));
    }

    @Test
    public void testGetSetComponent() {
        Vector v = new Vector(2);
        v.setComponent(0, 5.0);
        assertEquals(5.0, v.getComponent(0));
    }

    @Test
    public void testToCsvLine() {
        Vector v = new Vector(new double[]{1.0, 2.0, 3.0});
        assertEquals("1.0,2.0,3.0", v.toCsvLine());
    }
}
