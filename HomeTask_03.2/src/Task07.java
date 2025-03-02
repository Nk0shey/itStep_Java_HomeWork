import java.util.Scanner;

public class Task07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть число N: ");
        int N = scanner.nextInt();

        System.out.println("Введіть індекс біту i: ");
        int i = scanner.nextInt();

        int bitValue = (N >> i) & 1;
        System.out.println("Значення " + i + "-го біта: " + bitValue);

        scanner.close();
    }
}
