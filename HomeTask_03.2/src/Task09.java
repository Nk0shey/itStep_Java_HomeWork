import java.util.Scanner;

public class Task09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть значення для числа N");
        int N = scanner.nextInt();
        System.out.println("Введіть значення для числа M");
        int M = scanner.nextInt();

        boolean differentSigns = ((M ^ N) < 0);
        if (differentSigns) {
            System.out.println("Числа M та N мають різні знаки.");
        } else {
            System.out.println("Числа M та N мають однакові знаки.");
        }

        scanner.close();
    }
}
