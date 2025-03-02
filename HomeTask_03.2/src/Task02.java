import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введіть ціле число n: ");
        int n = sc.nextInt();

        int result = 1 << n;

        System.out.println("2 в степені " + n + " дорівнює: " + result);
    }
}
