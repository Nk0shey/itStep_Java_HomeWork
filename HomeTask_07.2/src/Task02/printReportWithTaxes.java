package Task02;

public class printReportWithTaxes {
    public static void printReportWithTaxes(Employee[] employees) {
        double totalNetSalary = 0;
        System.out.printf("%-20s %-10s %-10s %-15s%n", "П.І.Б.", "Податок, %", "Сума", "До сплати");
        for (Employee employee : employees) {
            double salary = employee.calculateSalary();
            double tax = employee.calculateTax();
            System.out.printf("%-20s %-10.0f %-10.2f %.2f%n", employee.name, tax / salary * 100, salary, salary - tax);
            totalNetSalary += salary - tax;
        }
        System.out.printf("Разом до сплати: %.2f грн%n", totalNetSalary);
    }
}
