package Task01;

/*

Розробіть і протестуйте набір класів для вирішення завдання
підрахунку заробітної плати співробітників якоїсь фірми.
На фірмі є декілька способів оплати праці:

 ставка — вказується, скільки співробітник отримує за
робочий день; по кожному співробітнику записується
кількість відпрацьованих днів в місяці;

 погодинна — вказується, скільки співробітник отримує
оплату в годину; по кожному співробітнику записується
кількість відпрацьованих годин в місяць;

 відрядна — вказується, скільки співробітник отримає за
виконану роботу; по кожному співробітнику записуються
суми з кожного виконаного завдання, яке працівник встиг
виконати за місяць.

 */

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
            new SalariedEmployee("Іваненко", 300, 10),
            new HourlyEmployee("Сидоренко", 50, 16),
            new PieceworkEmployee("Петренко", new double[]{1000, 2000, 2500})
        };

        PayrollReport.printReport(employees);
    }
}
