/*
Заповніть масив з 10 елементів випадковими числами від -10 до
+10. Підрахуйте кількість унікальних значень (що зустрічаються
в масиві один раз). Виведіть в консоль значення унікальних
елементів та індекси, під якими вони знаходяться в масиві.
 */

import java.util.Random;

public class Task06 {
    public static void main(String[] args) {
        int[] array = new int[10];

        int min = -10;
        int max = 10;

        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }

        System.out.println("Масив випадкових чисел: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        System.out.println("Унікальні елементи та їх індекси: ");
        int uniqueCount = 0;

        for (int i = 0; i < array.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i] == array[j]) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                System.out.println("Значення: " + array[i] + ", Індекс: " + i);
                uniqueCount++;
            }
        }

        System.out.println("\nКількість унікальних значень: " + uniqueCount);
    }
}
