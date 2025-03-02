import java.util.Scanner;

public class Task06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть число N: ");
        int N = scanner.nextInt();
        System.out.println("Число N у двійковій системі числення: " + Integer.toBinaryString(N));

        System.out.println();

        System.out.println("Введіть кількість останніх бітів k: ");
        int k = scanner.nextInt();

        int mask = (1 << k) - 1;
        int result = N & mask;

        System.out.println("Результат: " + Integer.toBinaryString(result));
    }
}
