package Task03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    public void testValidTriangle() throws InvalidTriangleException {
        Triangle triangle = new Triangle(3, 4, 5);
        assertEquals(3, triangle.getSideA());
        assertEquals(4, triangle.getSideB());
        assertEquals(5, triangle.getSideC());
        assertEquals(12, triangle.getPerimeter());
        assertEquals(6, triangle.getArea(), 0.001); // Точність до 3 знаків після коми
    }

    @Test
    public void testInvalidTriangle() {
        Exception exception = assertThrows(InvalidTriangleException.class, () -> {
            new Triangle(1, 2, 10);
        });
        assertEquals("Неможливо створити трикутник із заданими сторонами: 1.0, 2.0, 10.0", exception.getMessage());
    }

    @Test
    public void testNegativeSides() {
        Exception exception = assertThrows(InvalidTriangleException.class, () -> {
            new Triangle(-3, 4, 5);
        });
        assertEquals("Неможливо створити трикутник із заданими сторонами: -3.0, 4.0, 5.0", exception.getMessage());
    }

    @Test
    public void testZeroSides() {
        Exception exception = assertThrows(InvalidTriangleException.class, () -> {
            new Triangle(0, 4, 5);
        });
        assertEquals("Неможливо створити трикутник із заданими сторонами: 0.0, 4.0, 5.0", exception.getMessage());
    }
}