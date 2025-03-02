/*
Введіть рядок з клавіатури (латиницею). Із введеного рядка
виберіть всі слова, які починаються з голосних літер і
закінчуються приголосними. Виведіть відібрані слова у консоль.
 */

import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nВведіть рядок латиницею: ");
        String line = scanner.nextLine();

        String[] words = line.split("\\s+");

        String vowels = "aeiouAEIOU";

        System.out.println("\nСлова, що починаються з голосної і закінчуються приголосною: ");
        for (String word : words) {
            if (word.length() > 1) {
                char firstChar = word.charAt(0);
                char lastChar = word.charAt(word.length() - 1);

                if (vowels.indexOf(firstChar) != -1 && vowels.indexOf(lastChar) == -1) {
                    System.out.println(word);
                }
            }
        }
        scanner.close();
    }
}
