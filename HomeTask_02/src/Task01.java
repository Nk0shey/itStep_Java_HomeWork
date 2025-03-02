import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть перше число (x): ");
        int x = scanner.nextInt();

        System.out.println("Введіть друге число (y): ");
        int y = scanner.nextInt();

        int res1 = x / y;
        System.out.println("Результат цілісного ділення x на y: " + res1);

        int res2 = x % y;
        System.out.println("Залишок від ділення x на y: " + res2);

        double sqrtX = Math.sqrt(x);
        System.out.println("Квадратний корінь від x: " + sqrtX);
    }
}
