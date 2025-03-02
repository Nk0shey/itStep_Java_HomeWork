import java.util.Scanner;
public class Task05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введіть число N: ");
        int n = sc.nextInt();

        System.out.println("Введіть число, яке буде індексом біту i: ");
        int i = sc.nextInt();

        int result = n & ~(1 << i);
        System.out.println("Результат: " + Integer.toBinaryString(result));

        sc.close();
    }
}