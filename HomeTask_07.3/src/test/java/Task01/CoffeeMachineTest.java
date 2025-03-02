package Task01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoffeeMachineTest {

    @Test
    void turnOn() {
        CoffeeMachine machine = new CoffeeMachine(CoffeeMachine.Model.PREMIUM);
        machine.turnOn();
        assertTrue(machine.isOn(), "Machine should be on.");
    }

    @Test
    void turnOff() {
        CoffeeMachine machine = new CoffeeMachine(CoffeeMachine.Model.PREMIUM);
        machine.turnOn(); // First turn it on
        machine.turnOff();
        assertFalse(machine.isOn(), "Machine should be off.");
    }

    @Test
    void makeEspresso() {
        CoffeeMachine machine = new CoffeeMachine(CoffeeMachine.Model.PREMIUM);
        machine.turnOn();
        assertEquals("Еспресо готове!", machine.makeEspresso(), "Espresso should be prepared successfully.");
    }

    @Test
    void makeAmericano() {
        CoffeeMachine machine = new CoffeeMachine(CoffeeMachine.Model.PREMIUM);
        machine.turnOn();
        assertEquals("Американо готове!", machine.makeAmericano(), "Americano should be prepared successfully.");
    }

    @Test
    void cleanWasteBin() {
        CoffeeMachine machine = new CoffeeMachine(CoffeeMachine.Model.PREMIUM);
        machine.turnOn();
        // Prepare an espresso to fill the waste bin
        machine.makeEspresso();
        assertEquals("Бак з відпрацьованою кавою очищено.", machine.cleanWasteBin(), "Waste bin should be cleaned.");
    }
}
