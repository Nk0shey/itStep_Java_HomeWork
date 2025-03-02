import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введіть будь-яке число: ");
        int number = sc.nextInt();

        int result = number & ~1;
        System.out.println("Результат: " + Integer.toBinaryString(result));

        sc.close();
    }
}
