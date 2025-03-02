package Task02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeMachine2Test {

    private CoffeeMachine2 machine;

    @BeforeEach
    void setUp() {
        machine = new CoffeeMachine2(CoffeeMachine2.Model.PREMIUM);
        machine.turnOn();
    }

    @AfterEach
    void tearDown() {
        machine.turnOff();
    }

    @Test
    void makeEspresso() {
        String result = machine.makeEspresso();
        assertEquals("Еспресо готове!", result);
    }

    @Test
    void makeAmericano() {
        String result = machine.makeAmericano();
        assertEquals("Американо готове!", result);
    }

    @Test
    void makeCappuccino() {
        String result = machine.makeCappuccino(50.0);
        assertEquals("Капучино готове!", result);
    }

    @Test
    void makeLatte() {
        String result = machine.makeLatte(50.0);
        assertEquals("Лате готове!", result);
    }

    @Test
    void cleanWasteBin() {
        // Test for cleaning the waste bin
        machine.makeEspresso();  // Make an espresso to add waste
        machine.cleanWasteBin();
        // Check that the waste bin is empty
        assertEquals(0, machine.getWasteBinContent());
    }

    @Test
    void turnOn() {
        machine.turnOn();
        assertTrue(machine.isOn());
    }

    @Test
    void turnOff() {
        machine.turnOff();
        assertFalse(machine.isOn());
    }
}