/*
Напишіть програму, яка друкуватиме ромбоподібний рисунок на
основі рядка, введеного з клавіатури (максимальна довжина —
50 символів).
Приклад виведення для рядка testing:
   t
  te
 tex
text
tex
te
t
 */

import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть рядок (максимум 50 символів): ");
        String input = scanner.nextLine();

        if (input.length() > 50) {
            System.out.println("Рядок перевищує максимальну довжину 50 символів.");
            return;
        }

        int length = input.length();

        for (int i = 1; i <= length; i++) {
            for (int j = length - i; j > 0; j--) {
                System.out.print(" ");
            }
            System.out.println(input.substring(0, i));
        }

        for (int i = length - 1; i >= 1; i--) {
            System.out.println(input.substring(0, i));
        }
    }
}
