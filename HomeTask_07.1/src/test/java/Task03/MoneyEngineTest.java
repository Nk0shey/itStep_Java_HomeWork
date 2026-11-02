package Task03;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class MoneyEngineTest {
 @Test void additionCarriesCents() { assertEquals("2,10", new MoneyEngine(1,(byte)90).add(new MoneyEngine(0,(byte)20)).toString()); }
 @Test void negativeDifferenceFormatsCorrectly() { assertEquals("-0,50", new MoneyEngine(0,(byte)0).subtract(new MoneyEngine(0,(byte)50)).toString()); }
 @Test void multiplication() { assertEquals("3,00", new MoneyEngine(1,(byte)50).multiply(2).toString()); }
 @Test void division() { assertEquals("0,75", new MoneyEngine(1,(byte)50).divide(2).toString()); }
 @Test void zeroDivision() { assertThrows(ArithmeticException.class, () -> new MoneyEngine(1,(byte)0).divide(0)); }
 @Test void comparisons() { MoneyEngine a = new MoneyEngine(2,(byte)0); assertTrue(a.isGreaterThan(new MoneyEngine(1,(byte)99))); assertTrue(a.isEqualTo(new MoneyEngine(2,(byte)0))); }
 @Test void invalidValues() { assertThrows(IllegalArgumentException.class, () -> new MoneyEngine(0,(byte)100)); assertThrows(IllegalArgumentException.class, () -> new MoneyEngine(0,(byte)0).multiply(Double.NaN)); }
}
