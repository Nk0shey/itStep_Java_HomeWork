package Task02.Calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void testAddition() {
        assertEquals(5.0, calculator.add(2, 3));
    }

    @Test
    void testSubtraction() {
        assertEquals(1.0, calculator.subtract(4, 3));
    }

    @Test
    void testMultiplication() {
        assertEquals(12.0, calculator.multiply(4, 3));
    }

    @Test
    void testDivision() {
        assertEquals(2.0, calculator.divide(6, 3));
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.divide(1, 0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    void testMax() {
        assertEquals(5.0, calculator.max(5, 3));
    }

    @Test
    void testMin() {
        assertEquals(3.0, calculator.min(5, 3));
    }

    @Test
    void testPercentage() {
        assertEquals(20.0, calculator.percentage(200, 10));
    }

    @Test
    void testPower() {
        assertEquals(8.0, calculator.power(2, 3));
    }
}