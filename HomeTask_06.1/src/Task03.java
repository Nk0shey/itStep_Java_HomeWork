/*
В масиві зберігається n явно заданих текстових рядків. Створіть метод:
 який виводить вміст масиву в рядок через пробіл;
 який сортує масив у зворотному напрямку (не враховуючи регістр) від z до a;
 який сортує масив за кількістю слів в рядку (словарозділяються пробілами).
Програма має вивести рядки в початковому і відсортованому порядку.
Додатково: +1 бал за генерацію випадкових, унікальних рядків, реалізованих у
вигляді методу
 */

import java.util.*;

public class Task03 {
    private String[] strings;

    // Конструктор для створення масиву рядків
    public Task03(String[] strings) {
        this.strings = strings;
    }

    // Метод для виводу масиву в рядок через пробіл
    public void printArray() {
        System.out.println(String.join(" ", strings));
    }

    // Метод для сортування масиву у зворотному алфавітному порядку (без врахування регістру)
    public void sortByAlphabetReverse() {
        Arrays.sort(strings, (a, b) -> b.compareToIgnoreCase(a));
    }

    // Метод для сортування масиву за кількістю слів у рядках
    public void sortByWordCount() {
        Arrays.sort(strings, Comparator.comparingInt(s -> s.split("\\s+").length));
    }

    // Метод для генерації випадкових унікальних рядків
    public static String[] generateRandomUniqueStrings(int n, int length) {
        Set<String> uniqueStrings = new HashSet<>();
        Random random = new Random();

        while (uniqueStrings.size() < n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                char randomChar = (char) ('a' + random.nextInt(26));
                sb.append(randomChar);
            }
            uniqueStrings.add(sb.toString());
        }

        return uniqueStrings.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // Генерація випадкових рядків
        String[] randomStrings = generateRandomUniqueStrings(5, 8);

        // Створення об'єкта для роботи з масивом рядків
        Task03 processor = new Task03(randomStrings);

        System.out.println("Початковий масив:");
        processor.printArray();

        // Сортування за зворотним алфавітним порядком
        processor.sortByAlphabetReverse();
        System.out.println("Відсортовано у зворотному алфавітному порядку:");
        processor.printArray();

        // Сортування за кількістю слів у рядках
        processor.sortByWordCount();
        System.out.println("Відсортовано за кількістю слів:");
        processor.printArray();
    }
}
