package Task02.Calculator;

/*
Створіть клас «Калькулятор». Реалізуйте клас з такою
функціональністю:
 Додавання двох чисел.
 Віднімання двох чисел.
 Множення двох чисел.
 Ділення двох чисел.
 Максимум з двох чисел.
 Мінімум з двох чисел.
 Відсоток числа.
 Піднесення числа до степеня.
Протестуйте всі можливості створеного класу з використанням
JUnit
 */

public class Calculator {
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }

    public double max(double a, double b) {
        return Math.max(a, b);
    }

    public double min(double a, double b) {
        return Math.min(a, b);
    }

    public double percentage(double value, double percentage) {
        return (value * percentage) / 100;
    }

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}