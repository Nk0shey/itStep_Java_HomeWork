package Task01.Fraction;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FractionTest {
    @Test
    void testAddition() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
        assertEquals("5/6", f1.add(f2).toString());
    }

    @Test
    void testSubtraction() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
        assertEquals("1/6", f1.subtract(f2).toString());
    }

    @Test
    void testMultiplication() {
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(3, 4);
        assertEquals("1/2", f1.multiply(f2).toString());
    }

    @Test
    void testDivision() {
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(3, 4);
        assertEquals("8/9", f1.divide(f2).toString());
    }

    @Test
    void testZeroDenominator() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Fraction(1, 0));
        assertEquals("Denominator cannot be zero", exception.getMessage());
    }
}