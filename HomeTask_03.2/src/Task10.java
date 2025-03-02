import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть число M:");
        int M = scanner.nextInt();

        System.out.println("Введіть число N:");
        int N = scanner.nextInt();

        int min = N + ((M - N) & ((M - N) >> 31));

        System.out.println("Найменше число: " + min);

        scanner.close();
    }
}
