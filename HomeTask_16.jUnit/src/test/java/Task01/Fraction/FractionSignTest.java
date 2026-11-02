package Task01.Fraction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class FractionSignTest {
 @Test void denominatorPositive() { assertEquals("-1/2",new Fraction(1,-2).toString()); }
 @Test void zeroNormalizes() { assertEquals("0/1",new Fraction(0,-2).toString()); }
 @Test void doubleNegative() { assertEquals("1/2",new Fraction(-1,-2).toString()); }
}
