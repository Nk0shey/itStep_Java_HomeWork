package Task03;

public class printReportWithAdjustedTaxes {
    public static void printReportWithChildrenTax(Employee[] employees) {
        System.out.printf("%-20s %-10s %-10s %-15s%n", "П.І.Б.", "Податок, %", "Сума", "До сплати");
        double totalNetSalary = 0;
        for (Employee employee : employees) {
            double salary = employee.calculateSalary();
            double tax = employee.calculateTax();
            double netSalary = salary - tax;
            System.out.printf("%-20s %-10.0f %-10.2f %.2f%n", employee.name, tax / salary * 100, salary, netSalary);
            totalNetSalary += netSalary;
        }
        System.out.printf("Разом до сплати: %.2f грн%n", totalNetSalary);
    }

}
