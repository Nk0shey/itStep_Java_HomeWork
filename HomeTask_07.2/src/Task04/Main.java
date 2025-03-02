package Task04;

/*
На основі попереднього завдання, переробіть звіт з
урахуванням того, що співробітники з погодинною оплатою
половину зарплати одержують у валюті (тугриках) за курсом в
день нарахування заробітної плати.
 */

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new SalariedEmployee("Іваненко", true, 300, 10),
                new HourlyEmployee("Сидоренко", false, 50, 16, 8), // Курс 1 UAH = 8 тугриков
                new PieceworkEmployee("Петренко", false, new double[]{1000, 2000, 2500})
        };

        printReportWithCurrency.printReportWithCurrency(employees);
    }
}

