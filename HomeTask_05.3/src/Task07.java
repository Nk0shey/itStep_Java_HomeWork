/*
Заповніть масив розмірності n випадковими цифрами від 3 до
13. Підрахуйте, скільки разів трапляється кожна цифра. Виведіть
результат на екран. n — задається з клавіатури.
 */

import java.util.Random;
import java.util.Scanner;

public class Task07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість елементів у масиві: ");
        int size = scanner.nextInt();

        int[] randomArray = new int[size];
        int min = 3;
        int max = 13;
        Random random = new Random();

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(max - min + 1) + min;
        }

        System.out.println("Згенерований масив з рандомних чисел: ");
        for (int num : randomArray) {
            System.out.print(num + " ");
        }

        int[] counts = new int[max - min + 1];

        for (int num : randomArray) {
            counts[num - min]++;
        }

        System.out.println("\nКількість вхождень кожної цифри:");
        for (int i = min; i <= max; i++) {
            if (counts[i - min] > 0) {
                System.out.println(i + " – " + counts[i - min] + " раз(ів)");
            }
        }
        scanner.close();
    }
}
