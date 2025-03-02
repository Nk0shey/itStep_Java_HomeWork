/*
Введіть з клавіатури ціле число будь-якого розряду.
Програма має визначити і вивести в консоль кількість цифр в
цьому числі, а також суму цих чисел.
 */

import java.util.Scanner;

public class Task08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть ціле число: ");
        int number = scanner.nextInt();

        int count = 0;
        int sum = 0;

        number = Math.abs(number);

        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            count++;
            number /= 10;
        }

        System.out.println("Кількість цифр: " + count);
        System.out.println("Сума цифр: " + sum);

        scanner.close();
    }
}
