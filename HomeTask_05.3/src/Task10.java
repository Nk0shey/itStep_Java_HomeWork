/*
Заповніть масив розмірності n випадковими цифрами від 0 до
33. Знайдіть елемент масиву, який ділиться без остачі на
значення елемента зліва і значення елемента справа. Виведіть в
консоль значення початкового масиву. Виведіть індекс
знайденого елемента. Якщо такий не знайдено,виведіть -1. n —
задається з клавіатури.
 */

import java.util.Random;
import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть розмірність масиву (n): ");
        int n = scanner.nextInt();

        int[] randomArray = new int[n];
        int min = 0;
        int max = 33;
        Random random = new Random();

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(max - min + 1) + min;
        }

        System.out.println("Початковий масив: ");
        for (int num : randomArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        int foundIndex = -1;

        for (int i = 1; i < n - 1; i++) {
            if (randomArray[i - 1] != 0 && randomArray[i + 1] != 0) {
                if (randomArray[i] % randomArray[i - 1] == 0 && randomArray[i] % randomArray[i + 1] == 0) {
                    foundIndex = i;
                    break;
                }
            }
        }

        if (foundIndex != -1) {
            System.out.println("\nЗнайдений елемент на індексі: " + foundIndex);
        } else {
            System.out.println("\n-1");
        }

        scanner.close();
    }
}
