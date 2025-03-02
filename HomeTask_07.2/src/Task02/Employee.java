package Task02;

abstract class Employee {
    String name;

    public Employee(String name) {
        this.name = name;
    }

    public abstract double calculateSalary();

    public abstract String getPaymentType();

    public abstract double calculateTax();

}

class SalariedEmployee extends Employee {
    double dailyRate;
    int workedDays;

    public SalariedEmployee(String name, double dailyRate, int workedDays) {
        super(name);
        this.dailyRate = dailyRate;
        this.workedDays = workedDays;
    }

    @Override
    public double calculateSalary() {
        return dailyRate * workedDays;
    }

    @Override
    public String getPaymentType() {
        return "ставка";
    }

    @Override
    public double calculateTax() {
        return calculateSalary() * 0.2;
    }

}

class HourlyEmployee extends Employee {
    double hourlyRate;
    int workedHours;

    public HourlyEmployee(String name, double hourlyRate, int workedHours) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.workedHours = workedHours;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * workedHours;
    }

    @Override
    public String getPaymentType() {
        return "погодинна";
    }

    @Override
    public double calculateTax() {
        return calculateSalary() * 0.2; // 20% для ставок и погодинної
    }
}

class PieceworkEmployee extends Employee {
    double[] taskPayments;

    public PieceworkEmployee(String name, double[] taskPayments) {
        super(name);
        this.taskPayments = taskPayments;
    }

    @Override
    public double calculateSalary() {
        double total = 0;
        for (double payment : taskPayments) {
            total += payment;
        }
        return total;
    }

    @Override
    public String getPaymentType() {
        return "відрядна";
    }

    @Override
    public double calculateTax() {
        return calculateSalary() * 0.15; // 15% для відрядна
    }

}
