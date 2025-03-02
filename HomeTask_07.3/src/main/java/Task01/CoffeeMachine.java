package Task01;

/*
Напишіть програму, яка тестує кавомашини (JUnit).
Завдання 1:
Завод випускає різні моделі кавомашин з різнми
характеристиками.
Кавомашина завантажується меленою кавою та водою.
Максимальні значення завантаження залежать від моделі.
Для приготування однієї чашки витрачається:
 еспресо — 22 г. меленої кави та 30 мл. води;
 американо — 22 г. меленої кави та 100 мл. води.
Відпрацьована кава скидається у спеціальний бак,
місткість бака залежить від моделі.
Кавомашина може видавати різні помилки при роботі.
 «Відсутня вода».
 «Відсутня мелена кава».
 Переповнений бак з відпрацьованою кавою.
Кавомашина має такі кнопки:
 «Увімкнути».
 «Вимикнути».
 «Приготувати еспресо».
 «Приготувати американо».
 «Очистити бак з відпрацьованою кавою
 */

public class CoffeeMachine {
    private boolean isOn;
    private double coffeeAmount; // В кількості грамів
    private double waterAmount; // В кількості мілілітрів
    private double wasteBinCapacity; // Місткість бака для відпрацьованої кави
    private double wasteAmount; // Відпрацьована кава
    private Model model;

    public String makeCappuccino(double v) {
        return String.format("%.2f", v);
    }


    public enum Model {
        BASIC(250, 1000, 500), // для базової моделі
        PREMIUM(500, 2000, 1000); // для преміум моделі

        private final double maxCoffeeAmount;
        private final double maxWaterAmount;
        private final double maxWasteBinCapacity;

        Model(double maxCoffeeAmount, double maxWaterAmount, double maxWasteBinCapacity) {
            this.maxCoffeeAmount = maxCoffeeAmount;
            this.maxWaterAmount = maxWaterAmount;
            this.maxWasteBinCapacity = maxWasteBinCapacity;
        }
    }

    public CoffeeMachine(Model premium) {
        this.model = model;
        this.coffeeAmount = model.maxCoffeeAmount;
        this.waterAmount = model.maxWaterAmount;
        this.wasteBinCapacity = model.maxWasteBinCapacity;
        this.wasteAmount = 0;
        this.isOn = false;
    }

    public void turnOn() {
        this.isOn = true;
    }

    public boolean isOn() {
        return isOn;
    }

    public void turnOff() {
        this.isOn = false;
    }

    public String makeEspresso() {
        if (!isOn) {
            return "Кавомашина вимкнена.";
        }
        if (coffeeAmount < 22) {
            return "Відсутня мелена кава.";
        }
        if (waterAmount < 30) {
            return "Відсутня вода.";
        }
        if (wasteAmount + 22 > wasteBinCapacity) {
            return "Переповнений бак з відпрацьованою кавою.";
        }

        coffeeAmount -= 22;
        waterAmount -= 30;
        wasteAmount += 22;
        return "Еспресо готове!";
    }

    public String makeAmericano() {
        if (!isOn) {
            return "Кавомашина вимкнена.";
        }
        if (coffeeAmount < 22) {
            return "Відсутня мелена кава.";
        }
        if (waterAmount < 100) {
            return "Відсутня вода.";
        }
        if (wasteAmount + 22 > wasteBinCapacity) {
            return "Переповнений бак з відпрацьованою кавою.";
        }

        coffeeAmount -= 22;
        waterAmount -= 100;
        wasteAmount += 22;
        return "Американо готове!";
    }

    public String cleanWasteBin() {
        wasteAmount = 0;
        return "Бак з відпрацьованою кавою очищено.";
    }
}
