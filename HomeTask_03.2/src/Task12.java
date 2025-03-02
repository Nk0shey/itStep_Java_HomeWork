import java.util.Scanner;

public class Task12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть число N:");
        int N = scanner.nextInt();

        System.out.println("Число N у двійковій системі: " + Integer.toBinaryString(N));

        boolean hasZero = (N & (N + 1)) != 0;
        if (hasZero) {
            System.out.println("Число N містить хоча б один нуль у двійковому записі.");
        } else {
            System.out.println("Число N не містить жодного нуля у двійковому записі.");
        }
    }
}
