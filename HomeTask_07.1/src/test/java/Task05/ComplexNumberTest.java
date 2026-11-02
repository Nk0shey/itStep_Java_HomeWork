package Task05;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ComplexNumberTest {
 @Test void constructors() { assertEquals(1,new ComplexNumber(1,2).getReal()); assertEquals(2,new ComplexNumber(1,2).getImaginary()); }
 @Test void addition() { assertTrue(new ComplexNumber(1,2).add(new ComplexNumber(3,4)).isEqualTo(new ComplexNumber(4,6))); }
 @Test void subtraction() { assertTrue(new ComplexNumber(1,2).subtract(new ComplexNumber(3,4)).isEqualTo(new ComplexNumber(-2,-2))); }
 @Test void multiplication() { assertTrue(new ComplexNumber(1,2).multiply(new ComplexNumber(3,4)).isEqualTo(new ComplexNumber(-5,10))); }
 @Test void equality() { assertTrue(new ComplexNumber(1,2).isEqualTo(new ComplexNumber(1,2))); }
 @Test void inequality() { assertFalse(new ComplexNumber(1,2).isEqualTo(new ComplexNumber(1,3))); }
 @Test void fractionalParts() { assertEquals(0.5,new ComplexNumber(0.5,-0.25).getReal()); }
}
