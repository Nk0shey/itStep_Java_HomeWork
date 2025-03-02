/*
Напишіть програму, яка перевіряє, чи всі значення елементів
масиву однакові. Виведіть: Yes — якщо всі однакові, і No — якщо
є хоч одна відмінність. Задайте та ініціалізуйте масив на очатку
програми.
 */

import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість елементів у масиві: ");
        int size = scanner.nextInt();

        int[] array = new int[size];
        System.out.println("Введіть елементи масиву:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        boolean allEqual = true;
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[0]) {
                allEqual = false;
                break;
            }
        }

        if (allEqual) {
            System.out.println("Yes!");
        } else {
            System.out.println("No!");
        }

        scanner.close();
    }
}
