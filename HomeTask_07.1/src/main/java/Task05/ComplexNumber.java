package Task05;/*

Розробити програму для представлення комплексних чисел з
можливістю надання речової та уявної частин, як числами типів
double, так і цілими числами.
Забезпечити виконання операцій:
 порівняння чисел;
 додавання;
 віднімання;
 множення.
Протестуйте з використанням JUni
 */

public class ComplexNumber {
    private double real; // Речова частина
    private double imaginary; // Уявна частина

    // Конструктор з типами double
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Конструктор з типами int
    public ComplexNumber(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Метод для додавання
    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    // Метод для віднімання
    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imaginary - other.imaginary);
    }

    // Метод для множення
    public ComplexNumber multiply(ComplexNumber other) {
        double realPart = this.real * other.real - this.imaginary * other.imaginary;
        double imaginaryPart = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(realPart, imaginaryPart);
    }

    // Метод для порівняння
    public boolean isEqualTo(ComplexNumber other) {
        return this.real == other.real && this.imaginary == other.imaginary;
    }

    @Override
    public String toString() {
        return String.format("%.2f + %.2fi", real, imaginary);
    }

    // Геттери для тестування
    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }
}

