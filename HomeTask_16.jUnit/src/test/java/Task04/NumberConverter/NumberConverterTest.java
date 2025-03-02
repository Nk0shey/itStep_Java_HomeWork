package Task04.NumberConverter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberConverterTest {

    @Test
    void toBinary() {
        NumberConverter converter = new NumberConverter(10);
        assertEquals("1010", converter.toBinary());
    }

    @Test
    void toOctal() {
        NumberConverter converter = new NumberConverter(10);
        assertEquals("12", converter.toOctal());
    }

    @Test
    void toHexadecimal() {
        NumberConverter converter = new NumberConverter(255);
        assertEquals("ff", converter.toHexadecimal());

    }

    @Test
    void getValue() {
        NumberConverter converter = new NumberConverter(42);
        assertEquals(Integer.valueOf(42), converter.getValue());
    }
}