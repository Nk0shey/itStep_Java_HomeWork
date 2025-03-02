/*
Обчисліть результат піднесення числа m до степеня n,
використовуючи рекурсію. До статичного методу передається 2
параметри: число і степінь.
 */

import java.util.Scanner;

public class Task08 {
    public static int power(int m, int n) {
        if (n == 0) return 1;
        return m * power(m, n - 1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть число: ");
        int m = scanner.nextInt();

        System.out.println("Введіть степінь, до якої бажаєте піднести число: ");
        int n = scanner.nextInt();

        System.out.println("Результат: " + power(m, n));
    }
}
