/*
Дано натуральне число N. Виведіть всі його цифри по одній у
звичайному порядку, розділяючи їх пробілами або новими
рядками. Під час вирішення цього завдання не можна
використовувати рядки, списки, масиви, цикли. Дозволена лише
рекурсія і цілочислова арифметика.
Введення: 179
Виведення: 1 7 9
 */

public class Task05 {
    public static void singleNumbers(int n) {
        if (n == 0) return;
        singleNumbers(n / 10);
        System.out.print(n % 10 + " ");
    }

    public static void main(String[] args) {
        singleNumbers(179);
    }
}
