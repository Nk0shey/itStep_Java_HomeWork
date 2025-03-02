/*
Дано натуральне число N. Виведіть всі його цифри по одній у
зворотному порядку через пробіл. Дозволена тільки рекурсія і
цілочислова арифметика.
Введення: 179
Виведення: 9 7 1
 */

public class Task04 {
    public static void reversedNumbers(int n) {
        if (n == 0) return;
        System.out.print(n % 10 + " ");
        reversedNumbers(n / 10);
    }

    public static void main(String[] args) {
        reversedNumbers(179);
    }
}
