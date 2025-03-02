/*
Заповніть масив розмірності n випадковими цифрами від -2 до
n. Якщо в масиві є хоча б одне від'ємне значення менше -1,
замініть всі від'ємні значення в масиві на квадрат (у степіні 2)
цих значень. Виведіть початковий масив і його результат у
консоль
 */

import java.util.Random;
import java.util.Scanner;

public class Task09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть розмірність масиву (n), яке відповідатиме також максимальному числу у діапазоні: ");
        int number = scanner.nextInt();

        int[] randomArray = new int[number];
        int min = -2;
        int max = number;

        System.out.println("\nДіапазон встановлено. Мінімальне значення: " + min + ". " + "Максимальне значення: " + max + ".");

        Random random = new Random();
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt((max - min) + 1) + min;
        }

        System.out.println("\nМасив випадкових чисел: ");
        for (int num : randomArray) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        boolean hasNegativeLessThanMinusOne = false;

        for (int num : randomArray) {
            if (num < -1) {
                hasNegativeLessThanMinusOne = true;
                break;
            }
        }

        if (hasNegativeLessThanMinusOne) {
            for (int i = 0; i < randomArray.length; i++) {
                if (randomArray[i] < 0) {
                    randomArray[i] = randomArray[i] * randomArray[i];
                }
            }
        }
        System.out.println("\nМодифікований масив: ");
        for (int num : randomArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }
}
