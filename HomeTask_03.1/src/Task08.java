import java.util.Scanner;

public class Task08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть число N:");
        int N = scanner.nextInt();

        int highestOneBit = Integer.highestOneBit(N);

        int result = N ^ highestOneBit;

        System.out.println("Результат: " + Integer.toBinaryString(result));

        scanner.close();
    }
}
