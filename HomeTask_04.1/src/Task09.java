import java.util.Scanner;

public class Task09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть координати початку відрізка (х1, у1): ");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();

        System.out.println("Введіть координати кінця відрізка (х2, у2): ");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        if (y2 > y1) {
            System.out.println("Підйом");
        } else if (y1 > y2) {
            System.out.println("Спуск");
        } else if (x2 == x1) {
            System.out.println("Прямовисна");
        } else {
            System.out.println("Пряма дорога");
        }
    }
}
