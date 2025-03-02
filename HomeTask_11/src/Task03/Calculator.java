package Task03;

import java.io.Serializable;

public class Calculator implements Serializable {

    // Метод сложения
    public double add(double a, double b) {
        return a + b;
    }

    // Метод вычитания
    public double subtract(double a, double b) {
        return a - b;
    }

    // Метод умножения
    public double multiply(double a, double b) {
        return a * b;
    }

    // Метод деления
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль недопустимо!");
        }
        return a / b;
    }
}

