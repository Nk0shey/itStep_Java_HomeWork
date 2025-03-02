package Task06;

/*
Фірма вводить премії співробітникам, які відпрацювали
більше 200 годин на місяць, але не перебувають в офшорі.
Премії мають підсумовуватися до основної зарплати. Створіть
новий звіт з урахуванням змін.
 */

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new SalariedEmployee("Іваненко", true, false, 300, 10),
                new HourlyEmployee("Сидоренко", false, false, 50, 220, 8), // Сидоренко получает премию
                new PieceworkEmployee("Петренко", false, true, new double[]{1000, 2000, 2500}) // Петренко в офшоре
        };

        printReportWithBonuses.printReportWithBonuses(employees);
    }
}

