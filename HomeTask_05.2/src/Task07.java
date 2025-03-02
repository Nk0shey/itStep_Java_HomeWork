/*
Користувач вводить з клавіатури будь-який рядок. Змініть у
початковому рядку всі великі літери на маленькі, а маленькі —
великими. Якщо в рядку є цифри, замініть їх на символи
підкреслення, і виведіть результат у консоль
 */

import java.util.Scanner;

public class Task07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть будь-який рядок: ");
        String input = scanner.nextLine();

        StringBuilder result = new StringBuilder();

        for (char character : input.toCharArray()) {
            if (Character.isUpperCase(character)) {
                result.append(Character.toLowerCase(character));
            } else if (Character.isLowerCase(character)) {
                result.append(Character.toUpperCase(character));
            } else if (Character.isDigit(character)) {
                result.append('_');
            } else {
                result.append(character);
            }
        }

        System.out.println(result);

        scanner.close();
    }
}
