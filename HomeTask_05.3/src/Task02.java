/*
Заповніть масив з 30 елементів випадковими числами від -70 до
+50. Знайдіть мінімальний елемент і виведіть його в консоль.
Знайдіть максимальний елемент і виведіть його в консоль.
 */

import java.util.Random;

public class Task02 {
    public static void main(String[] args) {
        int[] array = new int[30];

        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(121) - 70;
        }

        System.out.println("Масив з рандомних чисел в діапазоні від -70 до +50:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        int min = array[0];
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }

        System.out.println("Мінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);

    }
}
