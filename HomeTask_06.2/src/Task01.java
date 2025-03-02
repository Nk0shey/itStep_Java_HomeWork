/*
Дано два цілих числа A і В. Виведіть усі числа від A до B
включно, у порядку зростання, якщо A < B, або в інакшому
випадку — у порядку спадання.
Введення: 51
Виведення: 5 4 3 2 1
 */

import java.util.Scanner;

public class Task01 {
    public static void printNumbers(int A, int B) {
        if (A == B) {
            System.out.print(A + " ");
        } else if (A < B) {
            System.out.print(A + " ");
            printNumbers(A + 1, B);
        } else {
            System.out.print(A + " ");
            printNumbers(A - 1, B);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введіть число А: ");
        int A = sc.nextInt();

        System.out.println("Введіть число B: ");
        int B = sc.nextInt();

        System.out.print("\nРезультат: ");
        printNumbers(A, B);
    }
}
