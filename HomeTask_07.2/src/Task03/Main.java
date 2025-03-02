package Task03;

/*
Візьміть за основу попереднє завдання і зробіть новий звіт
таким чином, що для співробітників, які не мають дітей,
ставка податку вище на 5%.
 */

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new SalariedEmployee("Іваненко", true, 300, 10),
                new HourlyEmployee("Сидоренко", false, 50, 16),
                new PieceworkEmployee("Петренко", false, new double[]{1000, 2000, 2500})
        };

        printReportWithAdjustedTaxes.printReportWithChildrenTax(employees);
    }
}

