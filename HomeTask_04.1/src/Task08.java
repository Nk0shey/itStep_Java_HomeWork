import java.util.Scanner;

public class Task08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть число Х: ");
        int x = scanner.nextInt();

        System.out.println("Введіть число Y: ");
        int y = scanner.nextInt();

        System.out.println("Обидва числа парні чи непарні?");
        if ((x % 2 == 0 && y % 2 == 0) || (x % 2 != 0 && y % 2 != 0)) {
            System.out.println("YES");
        }
    }
}
