import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть число N:");
        int N = scanner.nextInt();

        int bitCount = Integer.bitCount(N);

        System.out.println("Число N у двійковій системі: " + Integer.toBinaryString(N));

        System.out.println("Кількість одиничних бітів N: " + bitCount);
    }
}
