/*
З клавіатури вводиться ціле додатне число будь-якого розряду.
Переверніть це число, тобто цифри мають розташовуватися у зворотному порядку (наприклад, вводимо число
1234, а в результаті отримуємо 4321).
Не використовуйте рядки і масиви.
 */

import java.util.Scanner;

public class Task07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть ціле додатне число: ");
        int number = scanner.nextInt();
        int reversedNumber = 0;

        while (number > 0) {
            int lastDigit = number % 10;
            reversedNumber = reversedNumber * 10 + lastDigit;
            number /= 10;
        }

        System.out.println("Перевернуте число: " + reversedNumber);
    }
}
