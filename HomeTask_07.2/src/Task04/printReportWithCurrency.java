package Task04;

public class printReportWithCurrency {
    public static void printReportWithCurrency(Employee[] employees) {
        System.out.printf("%-20s %-10s %-10s %-20s%n", "П.І.Б.", "Податок, %", "Сума", "До сплати (грн/тугрики)");
        double totalNetSalaryHryvnia = 0;

        for (Employee employee : employees) {
            double salary = employee.calculateSalary();
            double tax = employee.calculateTax();
            double netSalary = salary - tax;

            if (employee instanceof HourlyEmployee) {
                HourlyEmployee hourlyEmployee = (HourlyEmployee) employee;
                double netSalaryHryvnia = hourlyEmployee.calculateSalaryInHryvnia() - hourlyEmployee.calculateSalaryInHryvnia() * hourlyEmployee.getBaseTaxRate();
                double netSalaryTugriks = hourlyEmployee.calculateSalaryInTugriks();

                System.out.printf("%-20s %-10.0f %-10.2f %.2f / %.2f%n",
                        employee.name, tax / salary * 100, salary, netSalaryHryvnia, netSalaryTugriks);
            } else {
                System.out.printf("%-20s %-10.0f %-10.2f %.2f%n",
                        employee.name, tax / salary * 100, salary, netSalary);
            }

            totalNetSalaryHryvnia += netSalary;
        }
        System.out.printf("Разом до сплати: %.2f грн%n", totalNetSalaryHryvnia);
    }

}
