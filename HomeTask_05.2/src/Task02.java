/*
Напишіть програму, яка створить рядок, в якому знаходяться всі
цілі числа, починаючи з 1, виписані в один рядок
«123456789101112131415...». Рядок має бути довжиною не
більше 1 000 символів.
За числом n (введеного з клавіатури), виведіть цифру на
n-й позиції (використовується нумерація з 1).
 */

import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        StringBuilder numberString = new StringBuilder();
        int i = 1;

        while (numberString.length() < 1000) {
            numberString.append(i);
            i++;
        }

        System.out.println("\nВиведене число: " + numberString);

        String resultString = numberString.substring(0, 1000);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведіть число n: ");
        int n = scanner.nextInt();

        if (n >= 1 && n <= numberString.length()) {
            System.out.println("\nЦифра на " + n + "-й позиції: " + resultString.charAt(n - 1));
        } else {
            System.out.println("\nЧисло n повинне бути в межах від 1 до 1000.");
        }
        scanner.close();
    }
}
