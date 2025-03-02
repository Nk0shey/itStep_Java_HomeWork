/*
Напишіть програму, яка перевіряє, чи всі значення елементів
масиву різні (не повторюються). Виведіть: Yes — якщо всі різні, і
No — якщо є хоч одне повторення. Задайте та ініціалізуйте масив
на початку програми
 */

import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість елементів у масиві: ");
        int size = scanner.nextInt();

        int[] array = new int[size];
        System.out.println("Введіть елементи масиву:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        boolean allUnique = true;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    allUnique = false;
                    break;
                }
            }
            if (!allUnique) break;
        }

        if (allUnique) {
            System.out.println("Yes!");
        } else {
            System.out.println("No!");
        }

        scanner.close();
    }
}
