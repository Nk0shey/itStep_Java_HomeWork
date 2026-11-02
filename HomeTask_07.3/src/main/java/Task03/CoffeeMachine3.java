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
        if (model == null) throw new IllegalArgumentException("Model cannot be null");
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

    private boolean prepareCoffee() {
        double needed = Math.max(0, 22 - groundCoffeeAmount);
        if (ungroundCoffeeAmount < needed) return false;
        ungroundCoffeeAmount -= needed;
        groundCoffeeAmount += needed;
        groundCoffeeAmount -= 22;
        wasteBinContent += 22;
        return true;
    }

    public String makeAmericano() {
        if (!isOn) return "Кавомашина вимкнена.";
        return prepareCoffee() ? "Американо готове!" : "Відсутня кава в зернах";
    }

    public String makeLatte(double milkAmount) {
        validateAmount(milkAmount);
        if (!isOn) return "Кавомашина вимкнена.";
        if (!prepareCoffee()) return "Відсутня кава в зернах";
        this.milkAmount += milkAmount;
        return "Лате готове!";
    }

    private void validateAmount(double amount) {
        if (!Double.isFinite(amount) || amount < 0) throw new IllegalArgumentException("Invalid amount");
    }

    public void loadGroundCoffee(double amount) {
        validateAmount(amount);
        groundCoffeeAmount += amount;
    }

    public void loadUngroundCoffee(double amount) {
        validateAmount(amount);
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
