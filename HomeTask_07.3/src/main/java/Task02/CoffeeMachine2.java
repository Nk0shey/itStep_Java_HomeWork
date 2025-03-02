package Task02;

/*
Після модернізації, завод почав випускати нові кавомашини, які
окрім попередніх функцій, можуть готувати капучино і лате.

Додалася вбудована ємність для молока, її розмір залежить від
марки кавомашини.
Додалась помилка:
 «Молоко відсутнє».
Додались кнопки:
 «Приготувати лате».
 «Приготувати капучино».
Кількість молока, яке витрачається на приготування капучино і
лате, задається під час приготування. Кількість споживання
кави та води — як при приготуванні чашки еспресо.
Протестуйте нові моделі кавомашин. Усі попередні тести мають
позначатися зеленим. Скористайтеся кодом з попереднього
завдання.
 */

public class CoffeeMachine2 {

    // Перелічення для моделей кавомашини
    public enum Model {
        BASIC, PREMIUM
    }

    private Model model;
    private double coffeeAmount;  // Кількість меленої кави
    private double waterAmount;   // Кількість води
    private double milkAmount;    // Кількість молока
    private double wasteBinCapacity;  // Місткість баку з відпрацьованою кавою
    private double wasteBinContent;   // Вміст баку з відпрацьованою кавою
    private boolean isOn;         // Статус кавомашини

    // Конструктор для ініціалізації моделі кавомашини
    public CoffeeMachine2(Model model) {
        if (model == null) {
            throw new IllegalArgumentException("Модель не може бути null");
        }
        this.model = model;
        this.isOn = false;
        this.coffeeAmount = 1000;  // Початкова кількість кави в грамах
        this.waterAmount = 2000;   // Початкова кількість води в мілілітрах
        this.milkAmount = 1000;    // Початкова кількість молока в мілілітрах
        this.wasteBinCapacity = 500; // Початкова місткість баку для відпрацьованої кави
        this.wasteBinContent = 0;   // Початковий вміст баку з відпрацьованою кавою
    }

    // Метод для приготування еспресо
    public String makeEspresso() {
        if (!isOn) return "Кавомашина вимкнена.";
        if (coffeeAmount < 22) return "Відсутня мелена кава.";
        if (waterAmount < 30) return "Відсутня вода.";
        if (wasteBinContent >= wasteBinCapacity) return "Переповнений бак з відпрацьованою кавою.";

        coffeeAmount -= 22;
        waterAmount -= 30;
        wasteBinContent += 1;

        return "Еспресо готове!";
    }

    // Метод для приготування американо
    public String makeAmericano() {
        if (!isOn) return "Кавомашина вимкнена.";
        if (coffeeAmount < 22) return "Відсутня мелена кава.";
        if (waterAmount < 100) return "Відсутня вода.";
        if (wasteBinContent >= wasteBinCapacity) return "Переповнений бак з відпрацьованою кавою.";

        coffeeAmount -= 22;
        waterAmount -= 100;
        wasteBinContent += 1;

        return "Американо готове!";
    }

    // Метод для приготування капучино
    public String makeCappuccino(double milkAmount) {
        if (!isOn) return "Кавомашина вимкнена.";
        if (coffeeAmount < 22) return "Відсутня мелена кава.";
        if (waterAmount < 30) return "Відсутня вода.";
        if (wasteBinContent >= wasteBinCapacity) return "Переповнений бак з відпрацьованою кавою.";
        if (this.milkAmount < milkAmount) return "Молоко відсутнє.";

        this.coffeeAmount -= 22;
        this.waterAmount -= 30;
        this.milkAmount -= milkAmount;
        this.wasteBinContent += 1;

        return "Капучино готове!";
    }

    // Метод для приготування лате
    public String makeLatte(double milkAmount) {
        if (!isOn) return "Кавомашина вимкнена.";
        if (coffeeAmount < 22) return "Відсутня мелена кава.";
        if (waterAmount < 30) return "Відсутня вода.";
        if (wasteBinContent >= wasteBinCapacity) return "Переповнений бак з відпрацьованою кавою.";
        if (this.milkAmount < milkAmount) return "Молоко відсутнє.";

        this.coffeeAmount -= 22;
        this.waterAmount -= 30;
        this.milkAmount -= milkAmount;
        this.wasteBinContent += 1;

        return "Лате готове!";
    }

    // Метод для очищення баку з відпрацьованою кавою
    public void cleanWasteBin() {
        wasteBinContent = 0;
    }

    // Метод для увімкнення кавомашини
    public void turnOn() {
        this.isOn = true;
    }

    // Метод для вимкнення кавомашини
    public void turnOff() {
        this.isOn = false;
    }

    // Перевірка, чи увімкнена кавомашина
    public boolean isOn() {
        return isOn;
    }

    public double getWasteBinContent() {
        return wasteBinContent;
    }
}
