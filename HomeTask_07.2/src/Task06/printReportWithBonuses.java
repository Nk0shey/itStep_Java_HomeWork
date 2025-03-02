package Task06;

public class printReportWithBonuses {
    public static void printReportWithBonuses(Employee[] employees) {
        System.out.printf("%-20s %-10s %-10s %-15s %-10s%n", "П.І.Б.", "Податок, %", "Сума", "До сплати", "Премія");
        double totalNetSalary = 0;

        for (Employee employee : employees) {
            double salary = employee.calculateSalary();
            double bonus = employee.calculateBonus();
            double tax = employee.calculateTax();
            double netSalary = salary + bonus - tax;

            if (employee instanceof HourlyEmployee) {
                HourlyEmployee hourlyEmployee = (HourlyEmployee) employee;
                double netSalaryHryvnia = hourlyEmployee.calculateSalaryInHryvnia() - hourlyEmployee.calculateSalaryInHryvnia() * hourlyEmployee.getBaseTaxRate();
                double netSalaryTugriks = hourlyEmployee.calculateSalaryInTugriks();

                System.out.printf("%-20s %-10.0f %-10.2f %.2f / %.2f %-10.2f%n",
                        employee.name, hourlyEmployee.isInOffshoreZone ? 0 : (tax / salary * 100),
                        salary, netSalaryHryvnia, netSalaryTugriks, bonus);
            } else {
                System.out.printf("%-20s %-10.0f %-10.2f %.2f %-10.2f%n",
                        employee.name, employee.isInOffshoreZone ? 0 : (tax / salary * 100), salary, netSalary, bonus);
            }

            totalNetSalary += netSalary;
        }

        System.out.printf("Разом до сплати: %.2f грн%n", totalNetSalary);
    }

}
