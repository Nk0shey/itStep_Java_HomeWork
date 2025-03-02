package Task03;

/*
Після модернізації, завод почав випускати нові кавомашини, в
які можна завантажувати крім меленої кави ще й не мелену.
Кавомашина сама меле каву. Емність бака для не меленої кави
залежить від моделі. Зернова кавапісля помелу потрапляє в бак
для меленої кави і вже звідти йде в приготування.
Щоб здешевити кавомашини, маркетинговий відділ придумав
скоротити функції цих кавомашин.
Дані кавомашини вміють готувати тільки:
 американо;
 лате.
Протестуйте нову кавомашину.
Попередні тести мають підсвічуватися зеленим.Додалась
помилка:
 «Відсутня кава в зернах»
 */

public class CoffeeMachine3 {

    private boolean isOn;
    private double groundCoffeeAmount;  // Amount of ground coffee
    private double ungroundCoffeeAmount;  // Amount of unground coffee (beans)
    private double milkAmount;  // Amount of milk in the machine
    private double wasteBinContent;  // Amount of waste generated

    public enum Model {
        BASIC, PREMIUM, ADVANCED  // Different models with different features (could affect capacity, etc.)
    }

    private Model model;

    public CoffeeMachine3(Model model) {
        this.model = model;
        this.isOn = false;
        this.groundCoffeeAmount = 0;
        this.ungroundCoffeeAmount = 0;
        this.milkAmount = 0;
        this.wasteBinContent = 0;
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }

    public String makeAmericano() {
        if (ungroundCoffeeAmount == 0) {
            return "Відсутня кава в зернах";  // No beans error
        }
        grindCoffee();  // Simulate grinding the coffee
        groundCoffeeAmount += 22;  // 22g of ground coffee used for Americano
        wasteBinContent += 22;  // Waste generated
        ungroundCoffeeAmount -= 22;  // Reduce unground coffee by the amount used
        return "Американо готове!";
    }

    public String makeLatte(double milkAmount) {
        if (ungroundCoffeeAmount == 0) {
            return "Відсутня кава в зернах";  // No beans error
        }
        grindCoffee();  // Simulate grinding the coffee
        groundCoffeeAmount += 22;  // 22g of ground coffee used for Latte
        wasteBinContent += 22;  // Waste generated
        this.milkAmount += milkAmount;  // Add the milk amount
        ungroundCoffeeAmount -= 22;  // Reduce unground coffee by the amount used
        return "Лате готове!";
    }

    private void grindCoffee() {
        if (ungroundCoffeeAmount > 0) {
            groundCoffeeAmount += 22;  // Assume we grind 22g of coffee for each cup
            ungroundCoffeeAmount -= 22;  // Reduce the unground coffee amount
        }
    }

    public void loadGroundCoffee(double amount) {
        groundCoffeeAmount += amount;
    }

    public void loadUngroundCoffee(double amount) {
        ungroundCoffeeAmount += amount;
    }

    public void cleanWasteBin() {
        wasteBinContent = 0;
    }

    public double getWasteBinContent() {
        return wasteBinContent;
    }

    public double getGroundCoffeeAmount() {
        return groundCoffeeAmount;
    }

    public double getUngroundCoffeeAmount() {
        return ungroundCoffeeAmount;
    }
}
