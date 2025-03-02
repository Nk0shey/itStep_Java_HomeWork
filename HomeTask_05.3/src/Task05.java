/*
Заповніть масив з 10 елементів випадковими числами від -10 до
+10. Підрахуйте кількість повторюваних значень. Виведіть в
консоль тільки повторювані елементи і кількість повторень.
Приклад:
0 – 5 разів
2 – 3 рази
7 – 1 разів
 */

import java.util.Random;

public class Task05 {
    public static void main(String[] args) {

        int[] randomArray = new int[10];

        int min = -10;
        int max = 10;

        Random random = new Random();
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(max - min + 1) + min;
        }

        System.out.println("Масив з рандомних чисел в діапазоні від -10 до 10: ");
        for (int num : randomArray) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        System.out.println("Повторювані елементи та кількість повторювань: ");

        boolean[] counted = new boolean[randomArray.length];

        for (int i = 0; i < randomArray.length; i++) {
            if (counted[i]) continue;

            int count = 1;
            for (int j = i + 1; j < randomArray.length; j++) {
                if (randomArray[i] == randomArray[j]) {
                    count++;
                    counted[j] = true;
                }
            }
            if (count > 1) {
                System.out.println(randomArray[i] + " – " + count + " разів");
            }
        }
    }
}
