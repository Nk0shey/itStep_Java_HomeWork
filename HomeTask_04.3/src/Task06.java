/*
Нарисуйте на екрані драбинку з символів. Кількість сходинок вказує користувач з клавіатури.
Приклад драбинки на 3 сходинки:
 */

import java.util.Scanner;

public class Task06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість сходинок: ");
        int steps = scanner.nextInt();

        for (int i = 1; i <= steps - 1; i++) {
            // Print spaces before the stars for alignment
            for (int j = 0; j < i - 1; j++) {
                System.out.print(" ");
            }
            // Print the first line of three stars
            System.out.println("***");

            // Print spaces before the single star aligned with the middle of the three stars
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            // Print the single star
            System.out.println("*");
        }

        // Print the final line of three stars aligned with the last step
        for (int j = 0; j < steps - 1; j++) { // Adjust spaces for final stars
            System.out.print(" ");
        }
        System.out.println("***");

        scanner.close();
    }
}
