/*
Нарисувати ялинку із символів «*». Кожен новий ярус
має бути ширший за попередній. З клавіатури вводиться
кількість ярусів, і висота першого (верхнього) ярусу ялинки
(кількість рядків у ярусі). Ялинка має бути симетричною.
 */

import java.util.Scanner;

public class Task09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість ярусів: ");
        int tiers = scanner.nextInt();
        System.out.print("Введіть висоту першого ярусу: ");
        int height = scanner.nextInt();

        int maxWidth = 2 * (height + tiers - 1) - 1;

        for (int i = 0; i < tiers; i++) {
            int currentHeight = height + i;
            int width = 2 * currentHeight - 1;

            for (int j = 0; j < currentHeight; j++) {
                int spacesBefore = (maxWidth - (2 * j + 1)) / 2;
                for (int k = 0; k < spacesBefore; k++) {
                    System.out.print(" ");
                }
                for (int k = 0; k < (2 * j + 1); k++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}

