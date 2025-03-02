package Task05;

abstract class Employee {
    String name;
    boolean hasChildren;
    boolean isInOffshoreZone;

    public Employee(String name, boolean hasChildren, boolean isInOffshoreZone) {
        this.name = name;
        this.hasChildren = hasChildren;
        this.isInOffshoreZone = isInOffshoreZone;
    }

    public abstract double calculateSalary();

    public abstract String getPaymentType();

    public double calculateTax() {
        double baseTaxRate = getBaseTaxRate();
        if (isInOffshoreZone) {
            return 0; // Если сотрудник в офшоре, налог не взимается
        }
        if (!hasChildren) {
            baseTaxRate += 0.05; // Увеличение ставки налога на 5%
        }
        return calculateSalary() * baseTaxRate;
    }

    protected abstract double getBaseTaxRate(); // Базовая ставка налога для типа оплаты
}

class SalariedEmployee extends Employee {
    private double dailyRate;
    private int workedDays;

    public SalariedEmployee(String name, boolean hasChildren, boolean isInOffshoreZone, double dailyRate, int workedDays) {
        super(name, hasChildren, isInOffshoreZone);
        this.dailyRate = dailyRate;
        this.workedDays = workedDays;
        this.isInOffshoreZone = isInOffshoreZone;
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
    protected double getBaseTaxRate() {
        return 0.2; // 20% базовая ставка налога
    }
}

class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int workedHours;
    private double currencyRate;

    public HourlyEmployee(String name, boolean hasChildren, boolean isInOffshoreZone, double hourlyRate, int workedHours, double currencyRate) {
        super(name, hasChildren, isInOffshoreZone);
        this.hourlyRate = hourlyRate;
        this.workedHours = workedHours;
        this.isInOffshoreZone = isInOffshoreZone;
        this.currencyRate = currencyRate;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * workedHours;
    }

    @Override
    public String getPaymentType() {
        return "погодинна";
    }

    public double calculateSalaryInHryvnia() {
        return calculateSalary() / 2; // Половина зарплаты в гривнах
    }

    public double calculateSalaryInTugriks() {
        return (calculateSalary() / 2) / currencyRate; // Половина зарплаты в тугриках
    }

    @Override
    protected double getBaseTaxRate() {
        return 0.2; // 20% базовая ставка налога
    }
}

class PieceworkEmployee extends Employee {
    private double[] taskPayments;

    public PieceworkEmployee(String name, boolean hasChildren, boolean isInOffshoreZone, double[] taskPayments) {
        super(name, hasChildren, isInOffshoreZone);
        this.taskPayments = taskPayments;
        this.isInOffshoreZone = isInOffshoreZone;
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
    protected double getBaseTaxRate() {
        return 0.15; // 15% базовая ставка налога
    }
}
