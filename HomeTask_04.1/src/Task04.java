import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть координати точки Х: ");
        double x = scanner.nextDouble();

        System.out.println("Введіть координати точки Y: ");
        double y = scanner.nextDouble();

        if (x > 0 && y > 0) {
            System.out.println("Точка знаходиться у I чверті.");
        } else if (x < 0 && y > 0) {
            System.out.println("Точка знаходиться у II чверті.");
        } else if (x < 0 && y < 0) {
            System.out.println("Точка знаходиться у III чверті.");
        } else if (x > 0 && y < 0) {
            System.out.println("Точка знаходиться у IV чверті.");
        } else if (x == 0 && y != 0) {
            System.out.println("Точка знаходиться на осі Y.");
        } else if (y == 0 && x != 0) {
            System.out.println("Точка знаходиться на осі X.");
        } else {
            System.out.println("Точка знаходиться у початку координат.");
        }
    }
}
