/*
Заповніть масив розмірності n словами, які складаються лише з
малих, латинських літер. Слова між собою розділені пробілами,
кількість пробілів випадкова — від 1 до
5. Підрахуйте загальну кількість масиву. n — задається з
клавіатури.
 */

import java.util.Random;
import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть розмірність масиву (n): ");
        int n = scanner.nextInt();

        String[] wordsArray = new String[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            wordsArray[i] = generateRandomWord(random, 3 + random.nextInt(5));
        }

        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < wordsArray.length; i++) {
            resultString.append(wordsArray[i]);

            if (i < wordsArray.length - 1) {
                int spaces = 1 + random.nextInt(5);
                resultString.append(" ".repeat(spaces));
            }
        }

        System.out.println("Згенерований рядок з пробілами:");
        System.out.println(resultString.toString());

        String[] words = resultString.toString().trim().split("\\s+");
        System.out.println("Загальна кількість слів: " + words.length);

        scanner.close();
    }

    public static String generateRandomWord(Random random, int length) {
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char letter = (char) ('a' + random.nextInt(26));
            word.append(letter);
        }
        return word.toString();
    }
}
