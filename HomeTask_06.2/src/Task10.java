/*
Напишіть статичний, рекурсивний метод знаходження
найбільшого спільного дільника двох цілих чисел.
Введення: 10 15
Виведення: 5
 */

public class Task10 {
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(10, 15));
    }
}
