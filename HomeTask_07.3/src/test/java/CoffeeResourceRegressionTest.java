import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Task03.CoffeeMachine3;
class CoffeeResourceRegressionTest {
 @Test void constructorRejectsNullModel() { assertThrows(IllegalArgumentException.class, () -> new Task01.CoffeeMachine(null)); }
 @Test void beansConsumedOnce() { CoffeeMachine3 m=new CoffeeMachine3(CoffeeMachine3.Model.ADVANCED);m.turnOn();m.loadUngroundCoffee(44);assertEquals("Американо готове!",m.makeAmericano());assertEquals(22,m.getUngroundCoffeeAmount());assertEquals("Американо готове!",m.makeAmericano());assertEquals(0,m.getUngroundCoffeeAmount());assertEquals(0,m.getGroundCoffeeAmount()); }
 @Test void insufficientBeansDoNotGoNegative() { CoffeeMachine3 m=new CoffeeMachine3(CoffeeMachine3.Model.BASIC);m.turnOn();m.loadUngroundCoffee(10);assertEquals("Відсутня кава в зернах",m.makeAmericano());assertEquals(10,m.getUngroundCoffeeAmount());assertEquals(0,m.getWasteBinContent()); }
 @Test void poweredOffMachineDoesNotConsume() { CoffeeMachine3 m=new CoffeeMachine3(CoffeeMachine3.Model.BASIC);m.loadUngroundCoffee(44);assertEquals("Кавомашина вимкнена.",m.makeAmericano());assertEquals(44,m.getUngroundCoffeeAmount()); }
 @Test void groundCoffeeCanBeUsed() { CoffeeMachine3 m=new CoffeeMachine3(CoffeeMachine3.Model.BASIC);m.turnOn();m.loadGroundCoffee(22);assertEquals("Американо готове!",m.makeAmericano());assertEquals(0,m.getGroundCoffeeAmount()); }
 @Test void negativeInputsRejected() { CoffeeMachine3 m=new CoffeeMachine3(CoffeeMachine3.Model.BASIC);assertThrows(IllegalArgumentException.class,()->m.loadUngroundCoffee(-1));assertThrows(IllegalArgumentException.class,()->m.makeLatte(Double.NaN)); }
}
