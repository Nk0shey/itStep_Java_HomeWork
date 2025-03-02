package Task03.NumberSet;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberSetTest {

    @Test
    void sum() {
        NumberSet set = new NumberSet(List.of(1, 2, 3, 4, 5));
        assertEquals(15, set.sum());
    }

    @Test
    void average() {
        NumberSet set = new NumberSet(List.of(1, 2, 3, 4, 5));
        assertEquals(3.0, set.average());
    }

    @Test
    void max() {
        NumberSet set = new NumberSet(List.of(1, 2, 3, 4, 5));
        assertEquals(5, set.max());
    }

    @Test
    void min() {
        NumberSet set = new NumberSet(List.of(1, 2, 3, 4, 5));
        assertEquals(1, set.min());
    }
}