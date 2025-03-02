/*
Покажіть значення змінної типу int в бітовій системі числення,
використовуючи тільки один цикл, керуючу змінну, виведення в
консоль і бітові операції.
Не використовуйте рядки і будь-які інші готові функції (методи)
 */

import java.util.Scanner;

public class Task07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number: ");
        int number = scanner.nextInt();

        for (int i = 31; i > 0; i--) {
            int bit = (number >> i) & 1;
            System.out.print(bit);
        }
    }
}
