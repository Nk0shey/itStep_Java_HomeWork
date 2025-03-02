import java.util.Scanner;

public class Task08 {
    public static final double LIGHT_SPEED = 343;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть приблизну кількість секунд, які пройшли в періоді між гуркотом грому та спалахом блискавки: ");
        double time = scanner.nextInt();

        double distance = time * LIGHT_SPEED;
        System.out.println("Відстань до місця удару блискавки: " + distance + " метрів.");
    }
}
