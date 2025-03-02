/*
Введіть рядок з клавіатури. Врядку мають бути слова, які можуть
бути роздільні пробілами або двокрапками. Обчисліть кількість
слів в рядку, в яких парна кількість літер.
 */

import java.util.Scanner;

public class Task05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть рядок (слова можуть бути розділені пробілами, двокрапками або комами): ");
        String input = scanner.nextLine();

        String[] words = input.split("[\\s,:]+");

        int evenLetterWordCount = 0;

        for (String word : words) {
            if (!word.isEmpty() && word.length() % 2 == 0) {
                evenLetterWordCount++;
            }
        }

        System.out.println("Кількість слів з парною кількістю літер: " + evenLetterWordCount);

        scanner.close();

    }
}
