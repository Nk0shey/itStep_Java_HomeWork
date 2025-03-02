package Task02;

/*
Для попереднього завдання виведіть звіт з врахуванням
податків. Для працівників, які на ставці і погодинній оплаті
— податок 20%.
Для працівників із відрядною оплатою праці — 15%. Програма
має вміти виводити звіт по всіх працівниках
фірми про заробітну плату у вигляді:
 */

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new SalariedEmployee("Іваненко", 300, 10),
                new HourlyEmployee("Сидоренко", 50, 16),
                new PieceworkEmployee("Петренко", new double[]{1000, 2000, 2500})
        };

        printReportWithTaxes.printReportWithTaxes(employees);
    }
}
