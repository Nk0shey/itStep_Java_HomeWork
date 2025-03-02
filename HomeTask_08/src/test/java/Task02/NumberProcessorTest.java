package Task02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberProcessorTest {

    NumberProcessor processor = new NumberProcessor();

    @Test
    public void testNegativeNumber() {
        Exception exception = assertThrows(NegativeNumberException.class, () -> {
            processor.processNumber(-5);
        });
        assertEquals("Число від'ємне: -5", exception.getMessage());
    }

    @Test
    public void testNumberTooLarge() {
        RuntimeException exception = assertThrows(NumberTooLargeException.class, () -> {
            processor.processNumber(150);
        });
        assertEquals("Число більше 100: 150", exception.getMessage());
    }

    @Test
    public void testValidNumber() {
        assertDoesNotThrow(() -> {
            processor.processNumber(50);
        });
    }
}