package Task03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeMachine3Test {

    private CoffeeMachine3 machine;

    @BeforeEach
    void setUp() {
        machine = new CoffeeMachine3(CoffeeMachine3.Model.ADVANCED);  // Initialize with the PREMIUM model
        machine.turnOn();  // Turn on the machine before each test
    }

    @AfterEach
    void tearDown() {
        machine.turnOff();
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

    @Test
    void makeAmericano() {
        machine.loadUngroundCoffee(100);  // Load 100g of unground coffee
        String result = machine.makeAmericano();  // Try to make Americano
        assertEquals("Американо готове!", result);  // Assert that the result is correct
    }

    @Test
    void makeLatte() {
        machine.loadUngroundCoffee(100);  // Load 100g of unground coffee
        String result = machine.makeLatte(50.0);  // Make Latte with 50 ml of milk
        assertEquals("Лате готове!", result);  // Assert the Latte is ready
    }

    @Test
    void makeAmericanoNoBeans() {
        machine.loadUngroundCoffee(0);  // Ensure no unground coffee is loaded
        String result = machine.makeAmericano();  // Try to make Americano
        assertEquals("Відсутня кава в зернах", result);  // Assert the error message
    }

    @Test
    void makeLatteNoBeans() {
        machine.loadUngroundCoffee(0);  // Ensure no unground coffee is loaded
        String result = machine.makeLatte(50.0);  // Try to make Latte
        assertEquals("Відсутня кава в зернах", result);  // Assert the error message
    }

    @Test
    void loadGroundCoffee() {
        double initialGroundCoffee = machine.getGroundCoffeeAmount();  // Get initial amount of ground coffee
        double amountToLoad = 50.0;
        machine.loadGroundCoffee(amountToLoad);  // Load 50g of ground coffee
        assertEquals(initialGroundCoffee + amountToLoad, machine.getGroundCoffeeAmount());  // Check that the amount increased
    }

    @Test
    void loadUngroundCoffee() {
        double initialUngroundCoffee = machine.getUngroundCoffeeAmount();  // Get initial amount of unground coffee
        double amountToLoad = 100.0;
        machine.loadUngroundCoffee(amountToLoad);  // Load 100g of unground coffee
        assertEquals(initialUngroundCoffee + amountToLoad, machine.getUngroundCoffeeAmount());  // Check that the amount increased
    }

    @Test
    void cleanWasteBin() {
        machine.loadUngroundCoffee(100);  // Load 100g of unground coffee
        machine.makeLatte(50.0);  // Make a Latte
        machine.cleanWasteBin();  // Clean the waste bin
        assertEquals(0, machine.getWasteBinContent());  // Check that the waste bin is empty
    }
}