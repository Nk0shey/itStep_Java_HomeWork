package Task05;

/*
Фірма переводить частину співробітників у офшорну зону.
Співробітники, які перебувають в офшорі, не сплачують
податків. Створіть новий звіт з урахуванням даного
нововведення.
 */

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new SalariedEmployee("Іваненко", true, false, 300, 10),
                new HourlyEmployee("Сидоренко", false, true, 50, 16, 8), // Курс 1 UAH = 8 тугриков
                new PieceworkEmployee("Петренко", false, true, new double[]{1000, 2000, 2500})
        };

        printReportWithOffshores.printReportWithOffshores(employees);
    }
}
