import java.util.Scanner;

public class Task09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть число: ");
        double number = scanner.nextDouble();

        if (number % 1 != 0) {
            System.out.println("Число " + number + " має речову (дробову) частину.");
        } else {
            System.out.println("Число " + number + " не має речової (дробової) частини.");
        }
    }
}
