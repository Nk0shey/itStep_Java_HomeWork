package Task01;

public class PayrollReport {
    public static void printReport(Employee[] employees) {
        double totalSalary = 0;
        System.out.printf("\n%-20s %-15s %-10s%n", "П.І.Б.", "Вид оплати", "Сума");
        for (Employee employee : employees) {
            double salary = employee.calculateSalary();
            System.out.printf("%-20s %-15s %.2f%n", employee.name, employee.getPaymentType(), salary);
            totalSalary += salary;
        }
        System.out.printf("\nРазом: %.2f грн%n", totalSalary);
    }
}
