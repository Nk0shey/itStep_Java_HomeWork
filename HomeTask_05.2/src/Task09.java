/*
Напишіть програму, яка перевіряє, чи є один рядок анаграмою
для іншого рядка (рядок може складатися з кількох слів і
символів пунктуації). Ігноруйте пробіли і пунктуацію під час
аналізу. Різниця у великих і маленьких літерах має ігноруватися.
Обидва рядка мають вводитися з клавіатури. Програма має
виводити Yes, якщо рядки є анаграмою, і No — якщо навпаки.
Приклад анаграми у віршах:
Рядок 1 “Я не лев!” – левеня;
Рядок 2 “Я не лис!” – лисеня.
 */

import java.util.Scanner;
import java.util.Arrays;

public class Task09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть перший рядок:");
        String firstString = scanner.nextLine();

        System.out.println("Введіть другий рядок:");
        String secondString = scanner.nextLine();

        if (areAnagrams(firstString, secondString)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        scanner.close();
    }

    public static boolean areAnagrams(String str1, String str2) {
        String cleanedStr1 = str1.replaceAll("[\\W]", "").toLowerCase();
        String cleanedStr2 = str2.replaceAll("[\\W]", "").toLowerCase();

        if (cleanedStr1.length() != cleanedStr2.length()) {
            return false;
        }

        char[] sortedStr1 = cleanedStr1.toCharArray();
        char[] sortedStr2 = cleanedStr2.toCharArray();

        Arrays.sort(sortedStr1);
        Arrays.sort(sortedStr2);

        return Arrays.equals(sortedStr1, sortedStr2);
    }
}
