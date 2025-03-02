/*
Заповніть масив розмірності n випадковими, малими
латинськими літерами. Підрахуйте, скільки разів трапляється
кожна літера. Виведіть літери, які трапляються більше 3 разів. n
— задається з клавіатури.
 */

import java.util.Random;
import java.util.Scanner;

public class Task08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть розмірність масиву (n): ");
        int size = scanner.nextInt();

        char[] lettersArray = new char[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            lettersArray[i] = (char) ('a' + random.nextInt(26)); // від 'a' до 'z'
        }

        System.out.println("Згенерований масив літер:");
        for (char letter : lettersArray) {
            System.out.print(letter + " ");
        }
        System.out.println();

        int[] count = new int[26];

        for (char letter : lettersArray) {
            count[letter - 'a']++;
        }

        System.out.println("Літери, які трапляються більше 3 разів:");
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 3) {
                System.out.println((char) (i + 'a') + " – " + count[i] + " раз(и/ів)");
            }
        }

        scanner.close();
    }
}
