package Task01;

abstract class Employee {
    String name;

    public Employee(String name) {
        this.name = name;
    }

    public abstract double calculateSalary();

    public abstract String getPaymentType();

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
}
